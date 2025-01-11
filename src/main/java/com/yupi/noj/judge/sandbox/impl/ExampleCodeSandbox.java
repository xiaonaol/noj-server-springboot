package com.yupi.noj.judge.sandbox.impl;

import com.yupi.noj.judge.sandbox.CodeSandbox;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeRequest;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeResponse;
import com.yupi.noj.judge.sandbox.model.JudgeInfo;
import com.yupi.noj.model.enums.JudgeInfoMessageEnum;
import com.yupi.noj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例沙箱
 *
 * @author xiaonaol
 * @date 2025/1/7
 **/
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCodeRequest(ExecuteCodeRequest executeCodeRequest) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();

        List<String> inputList = executeCodeRequest.getInputList();
        String code = executeCodeRequest.getCode();
        String language = executeCodeRequest.getLanguage();

        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        executeCodeResponse.setJudgeInfo(new JudgeInfo(JudgeInfoMessageEnum.ACCEPT.getText(), 100L, 100L));

        return executeCodeResponse;
    }
}
