package com.yupi.noj.judge;

import com.yupi.noj.judge.strategy.DefaultJudgeStrategy;
import com.yupi.noj.judge.strategy.JavaJudgeStrategy;
import com.yupi.noj.judge.strategy.JudgeContext;
import com.yupi.noj.judge.strategy.JudgeStrategy;
import com.yupi.noj.judge.sandbox.model.JudgeInfo;
import com.yupi.noj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题策略管理
 *
 * @author xiaonaol
 * @date 2025/1/8
 **/
@Service
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
