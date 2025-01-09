package com.yupi.noj.judge.sandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiaonaol
 * @date 2025/1/7
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {

    /**
     * 程序输出
     */
    private List<String> outputList;

    /**
     * 语言
     */
    private String language;

    /**
     * 接口信息
     */
    private String message;

    /**
     * 运行状态
     */
    private Integer status;

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;
}
