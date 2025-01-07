package com.yupi.noj.judge.sandbox.model;

import com.yupi.noj.judge.sandbox.CodeSandbox;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xiaonaol
 * @date 2025/1/7
 **/
@AllArgsConstructor
@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private CodeSandbox codeSandbox;

    @Override
    public ExecuteCodeResponse executeCodeRequest(ExecuteCodeRequest executeCodeRequest) {
        log.info(executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCodeRequest(executeCodeRequest);
        log.info(executeCodeResponse.toString());
        return null;
    }
}
