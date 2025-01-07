package com.yupi.noj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑请求
 *
 * @author xiaonaol
 * @date 2025/1/4
 **/
@Data
public class QuestionEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 题目
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 答案
     */
    private String answer;

    /**
     * 判题用例
     */
    private String judgeCase;

    /**
     * 判题设置
     */
    private String judgeConfig;

    private static final long serialVersionUID = 1L;
}
