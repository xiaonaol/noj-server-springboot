package com.yupi.noj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.noj.model.dto.question.QuestionQueryRequest;
import com.yupi.noj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.noj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author xiaon
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2025-01-04 21:27:08
*/
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询包装类
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取封装类
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取封装类
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> uestionPage, HttpServletRequest request);
}
