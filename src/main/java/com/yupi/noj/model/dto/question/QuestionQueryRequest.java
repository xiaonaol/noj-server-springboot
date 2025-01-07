package com.yupi.noj.model.dto.question;

import com.yupi.noj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询请求
 *

 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * id
     */
    private String title;

    /**
     * 搜索词
     */
    private String content;


    /**
     * 标签列表
     */
    private List<String> tags;

    /**
     * 至少有一个标签
     */
    private String answer;

    /**
     * 创建用户
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}