package com.yupi.noj.judge.strategy;

import com.yupi.noj.model.dto.question.JudgeCase;
import com.yupi.noj.judge.sandbox.model.JudgeInfo;
import com.yupi.noj.model.entity.Question;
import com.yupi.noj.model.entity.QuestionSubmit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiaonaol
 * @date 2025/1/8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeContext {

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;

    /**
     * 输入用例
     */
    private List<String> inputList;

    /**
     * 输出用例
     */
    private List<String> outputList;

    /**
     * 答案用例
     */
    private List<JudgeCase> judgeCaseList;

    /**
     * 题目
     */
    private Question question;

    /**
     * 提交信息
     */
    private QuestionSubmit questionSubmit;

}
