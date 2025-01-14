package com.yupi.noj.judge;

import com.yupi.noj.judge.strategy.DefaultJudgeStrategy;
import com.yupi.noj.judge.strategy.JavaJudgeStrategy;
import com.yupi.noj.judge.strategy.JudgeContext;
import com.yupi.noj.judge.strategy.JudgeStrategy;
import com.yupi.noj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.noj.model.entity.QuestionSubmit;

/**
 * 判题策略管理
 *
 * @author xiaonaol
 * @date 2025/1/8
 **/
public class JudgeManager {


    /**
     * 根据language执行判题
     *
     * @param judgeContext
     * @author xiaonaol
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {

        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
