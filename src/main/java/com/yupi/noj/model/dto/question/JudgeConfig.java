package com.yupi.noj.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 * @author xiaonaol
 * @date 2025/1/4
 **/
@Data
public class JudgeConfig {

    private Long timeLimit;

    private Long memoryLimit;

    private String stackLimit;
}
