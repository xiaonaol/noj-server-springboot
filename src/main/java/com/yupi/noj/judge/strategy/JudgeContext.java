package com.yupi.noj.judge.strategy;

import com.yupi.noj.model.dto.question.JudgeCase;
import com.yupi.noj.model.dto.questionsubmit.JudgeInfo;
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

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
