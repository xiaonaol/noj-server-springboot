package com.yupi.noj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.noj.common.BaseResponse;
import com.yupi.noj.common.ErrorCode;
import com.yupi.noj.common.ResultUtils;
import com.yupi.noj.exception.BusinessException;
import com.yupi.noj.judge.JudgeService;
import com.yupi.noj.model.dto.question.QuestionQueryRequest;
import com.yupi.noj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.noj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.noj.model.entity.Question;
import com.yupi.noj.model.entity.QuestionSubmit;
import com.yupi.noj.model.entity.User;
import com.yupi.noj.model.vo.QuestionSubmitVO;
import com.yupi.noj.service.QuestionService;
import com.yupi.noj.service.QuestionSubmitService;
import com.yupi.noj.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 题目提交接口
 */
@RestController
//@RequestMapping("/question_submit")
@Deprecated
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

//    /**
//     * 提交题目
//     *
//     * @param questionSubmitAddRequest
//     * @param request
//     * @author xiaonaol
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
//                                         HttpServletRequest request) {
//        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // 登录才能提交
//        final User loginUser = userService.getLoginUser(request);
//        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
//
//        return ResultUtils.success(result);
//    }
//
//
//    /**
//     * 分页获取提交题目列表
//     *
//     * @param questionSubmitQueryRequest
//     * @param request
//     * @author xiaonaol
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
//                                                                         HttpServletRequest request) {
//        long current = questionSubmitQueryRequest.getCurrent();
//        long size = questionSubmitQueryRequest.getPageSize();
//        // 原始数据信息
//        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
//                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
//        User loginUser = userService.getLoginUser(request);
//        // 返回脱敏信息
//        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(
//                questionSubmitPage, loginUser
//        ));
//    }
}
