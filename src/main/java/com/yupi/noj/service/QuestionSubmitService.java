package com.yupi.noj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.noj.model.dto.question.QuestionQueryRequest;
import com.yupi.noj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.noj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.noj.model.entity.Question;
import com.yupi.noj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.noj.model.entity.User;
import com.yupi.noj.model.vo.QuestionSubmitVO;
import com.yupi.noj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author xiaon
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-01-04 21:28:02
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 提交问题
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询包装类
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取封装类
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取封装类
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
