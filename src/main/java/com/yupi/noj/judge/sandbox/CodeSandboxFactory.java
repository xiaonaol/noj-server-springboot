package com.yupi.noj.judge.sandbox;

import com.yupi.noj.judge.sandbox.impl.ExampleCodeSandbox;
import com.yupi.noj.judge.sandbox.impl.RemoteCodeSandbox;
import com.yupi.noj.judge.sandbox.impl.ThirdPartyCodeSandbox;

/**
 * 通过传入的字符串获取对应的代码沙箱
 * 
 * @author xiaonaol
 * @date 2025/1/7
 **/
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱实例
     *
     * @param type
     * @return CodeSandbox
     * @author xiaonaol
     */
    // todo 可以尝试复用代码沙箱类
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "remote": return new RemoteCodeSandbox();
            case "thirdParty": return new ThirdPartyCodeSandbox();
            default: return new ExampleCodeSandbox();
        }
    }
}
