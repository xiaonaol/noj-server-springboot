package com.yupi.noj.judge.sandbox;

import com.yupi.noj.judge.sandbox.model.ExecuteCodeRequest;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaonaol
 * @date 2025/1/7
 **/
@AllArgsConstructor
@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    @Override
    public ExecuteCodeResponse executeCodeRequest(ExecuteCodeRequest executeCodeRequest) {
        log.info(executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCodeRequest(executeCodeRequest);
        log.info(executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
