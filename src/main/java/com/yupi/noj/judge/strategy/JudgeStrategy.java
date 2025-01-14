package com.yupi.noj.judge.strategy;


import com.yupi.noj.model.dto.questionsubmit.JudgeInfo;

/**
 * 判题策略
 * @author xiaonaol
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @author xiaonaol
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
