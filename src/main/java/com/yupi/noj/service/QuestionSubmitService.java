package com.yupi.noj.service;

import com.yupi.noj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.noj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.noj.model.entity.User;

/**
* @author xiaon
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-01-04 21:28:02
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);
}
