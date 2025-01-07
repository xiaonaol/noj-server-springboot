package com.yupi.noj.judge.sandbox;


import com.yupi.noj.judge.sandbox.model.ExecuteCodeRequest;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口
 *
 * @author xiaonaol
 */
public interface CodeSandbox {
    
    
    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return ExecuteCodeResponse
     * @author xiaonaol
     */
    ExecuteCodeResponse executeCodeRequest(ExecuteCodeRequest executeCodeRequest);
}
