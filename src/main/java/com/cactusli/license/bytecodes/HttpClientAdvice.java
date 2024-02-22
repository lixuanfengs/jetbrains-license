package com.cactusli.license.bytecodes;

import net.bytebuddy.asm.Advice;

import java.net.SocketTimeoutException;

/**
 * Package: com.lemonzuo.license.HttpAd
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/2/22 15:15
 * @Github https://github.com/lixuanfengs
 */
public class HttpClientAdvice {

    @Advice.OnMethodExit
    public static void intercept(@Advice.This Object x) throws Exception {
        if (x.toString().contains("validateKey.action")){
            throw new SocketTimeoutException();
        }

    }

}
