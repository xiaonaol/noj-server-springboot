package com.yupi.noj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新请求
 *
 * @author xiaonaol
 * @date 2025/1/4
 **/
@Data
public class QuestionUpdateRequest implements Serializable {

    private Long id;

    private String title;

    private String content;

    private List<String> tags;

    private String answer;

    private List<JudgeCase> judgeCase;

    private List<JudgeConfig> judgeConfig;

    private static final long serialVersionUID = 1L;
}
