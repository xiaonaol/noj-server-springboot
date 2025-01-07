package com.yupi.noj.judge.sandbox.model;

import com.yupi.noj.model.dto.question.JudgeConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 执行代码请求
 *
 * @author xiaonaol
 * @date 2025/1/7
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeRequest {

    private List<String> inputList;

    private String code;

    private String language;

    private JudgeConfig judgeConfig;
}
