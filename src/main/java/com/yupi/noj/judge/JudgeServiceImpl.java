package com.yupi.noj.judge;

import cn.hutool.json.JSONUtil;
import com.yupi.noj.common.ErrorCode;
import com.yupi.noj.exception.BusinessException;
import com.yupi.noj.judge.sandbox.CodeSandbox;
import com.yupi.noj.judge.sandbox.CodeSandboxFactory;
import com.yupi.noj.judge.sandbox.CodeSandboxProxy;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeRequest;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeResponse;
import com.yupi.noj.judge.strategy.JudgeContext;
import com.yupi.noj.model.dto.question.JudgeCase;
import com.yupi.noj.judge.sandbox.model.JudgeInfo;
import com.yupi.noj.model.entity.Question;
import com.yupi.noj.model.entity.QuestionSubmit;
import com.yupi.noj.model.enums.JudgeInfoMessageEnum;
import com.yupi.noj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.noj.service.QuestionService;
import com.yupi.noj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 执行判题
 *
 * @author xiaonaol
 * @date 2025/1/7
 **/
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;


    /**
     * 执行判题
     *
     * @param questionSubmitId 提交信息id
     * @author xiaonaol
     */
    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {

        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交信息不存在");
        }

        // 更新提交状态
        if (!Objects.equals(questionSubmit.getStatus(), QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "已在判题中");
        }
        questionSubmit.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean update = questionSubmitService.updateById(questionSubmit);
        if (!update) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "更新提交状态失败");
        }

        Question question = questionService.getById(questionSubmit.getQuestionId());
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }

        // todo 线程安全
        question.submitNumbIncrement();
        questionService.updateById(question);

        // 获取语言对应的代码沙箱
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = questionSubmit.getCode();
        String language = questionSubmit.getLanguage();
        
        // 获取输入用例
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        // 代码沙箱执行代码并返回响应
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCodeRequest(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        JudgeInfo judgeInfo = executeCodeResponse.getJudgeInfo();

        // 执行判题策略
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(judgeInfo);
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);
        judgeInfo = judgeManager.doJudge(judgeContext);

        // 修改数据库中的判题结果
        questionSubmit.setId(questionSubmitId);
        questionSubmit.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionSubmitService.updateById(questionSubmit);
        if (!update) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "提交状态更新失败");
        }

        // todo 通过数+1 线程安全
        if (judgeInfo.getMessage().equals(JudgeInfoMessageEnum.ACCEPT.getValue())) {
            question.acceptedNumIncrement();
            boolean succeed = questionService.updateById(question);
            if (!succeed) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "增加通过数失败");
            }
        }

        return questionSubmit;
    }
}
