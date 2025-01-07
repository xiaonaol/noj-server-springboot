package com.yupi.noj.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 * @author xiaonaol
 * @date 2025/1/4
 **/
@Data
public class JudgeConfig {


    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（kb）
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（kb）
     */
    private Long stackLimit;
}
