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

    private String message;

    private Long memory;

    private Long time;
}