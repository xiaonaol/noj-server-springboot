package com.yupi.noj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaonaol
 * @date 2025/1/4
 **/
@Data
public class QuestionAddRequest implements Serializable {

    private String title;

    private String content;

    private List<String> tags;

    private String answer;

    private String judgeCase;

    private String judgeConfig;

    private static final long serialVersionUID = 1L;
}
