package com.yupi.noj.judge.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaonaol
 * @date 2025/1/4
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memory;

    /**
     * 消耗时间
     */
    private Long time;
}
