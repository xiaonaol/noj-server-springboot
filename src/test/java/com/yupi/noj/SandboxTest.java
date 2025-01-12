package com.yupi.noj;

import com.yupi.noj.common.ResultUtils;
import com.yupi.noj.judge.sandbox.CodeSandbox;
import com.yupi.noj.judge.sandbox.CodeSandboxFactory;
import com.yupi.noj.judge.sandbox.CodeSandboxProxy;
import com.yupi.noj.judge.sandbox.impl.RemoteCodeSandbox;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeRequest;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeResponse;
import com.yupi.noj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.noj.model.entity.User;
import com.yupi.noj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.noj.model.vo.LoginUserVO;
import com.yupi.noj.service.QuestionService;
import com.yupi.noj.service.QuestionSubmitService;
import com.yupi.noj.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class CodeSandboxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Resource
    private UserService userService;
    
    @Resource
    private QuestionSubmitService questionSubmitService;

    @Test
    void executeCodeSuccess() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCodeRequest(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    @Test
    void executeCodeCompileError() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parse;\n" +
                "        int b = Integer.parse;\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCodeRequest(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }
    
    @Test 
    void doQuestionSubmitTest() {
        QuestionSubmitAddRequest questionSubmitAddRequest = new QuestionSubmitAddRequest();
        questionSubmitAddRequest.setLanguage(QuestionSubmitLanguageEnum.JAVA.getValue());
        questionSubmitAddRequest.setCode(
                "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(a + b);\n" +
                "    }\n" +
                "}");
        questionSubmitAddRequest.setQuestionId(1878310033252384770L);

        User loginUser = new User();
        loginUser.setId(1876187774928805889L);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);

        System.out.println(ResultUtils.success(result));
    }
}