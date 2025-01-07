package com.yupi.noj.judge;

import com.yupi.noj.model.entity.QuestionSubmit;

public interface JudgeService {

    QuestionSubmit doJudge(long questionSubmitId);
}
