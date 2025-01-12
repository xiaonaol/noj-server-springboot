package com.yupi.noj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.yupi.noj.model.dto.question.JudgeCase;
import com.yupi.noj.model.dto.question.JudgeConfig;
import com.yupi.noj.judge.sandbox.model.JudgeInfo;
import com.yupi.noj.model.entity.Question;
import com.yupi.noj.model.enums.JudgeInfoMessageEnum;

import java.util.List;
import java.util.Objects;

/**
 * 默认判题策略
 *
 * @author xiaonaol
 * @date 2025/1/8
 **/
public class DefaultJudgeStrategy implements JudgeStrategy{

    /**
     * 执行判题
     *
     * @param judgeContext
     * @author xiaonaol
     */
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {

        // todo 优化掉judgeInfoResponse，用judgeInfo代替

        return null;
    }
}
