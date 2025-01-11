package com.yupi.noj.judge.sandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yupi.noj.common.ErrorCode;
import com.yupi.noj.exception.BusinessException;
import com.yupi.noj.judge.sandbox.CodeSandbox;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeRequest;
import com.yupi.noj.judge.sandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 远程代码沙箱（实际调用接口）
 *
 * @author xiaonaol
 * @date 2025/1/7
 **/
@Slf4j
public class RemoteCodeSandbox implements CodeSandbox {

    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCodeRequest(ExecuteCodeRequest executeCodeRequest) {
        log.info("远程代码沙箱");
        String url ="http://172.27.110.196:9900/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,
                    "execute remote sandbox error, message = " + responseStr );
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
