package com.cactusli.license;

import com.cactusli.license.bytecodes.BigIntegerAdvice;
import com.cactusli.license.bytecodes.HttpClientAdvice;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Package: com.lemonzuo.license
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2024/2/22 15:12
 * @Github https://github.com/lixuanfengs
 */
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) throws Exception {
        System.out.println("premain");
        AgentBuilder agentBuilder = new AgentBuilder.Default()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .with(AgentBuilder.InitializationStrategy.NoOp.INSTANCE)
                .with(AgentBuilder.TypeStrategy.Default.REDEFINE)
                .ignore(ElementMatchers.nameStartsWith("net.bytebuddy."));
//                .with(new MyAgentListener());
        // 使得证书验证通过
        agentBuilder.type(ElementMatchers.named("java.math.BigInteger"))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) -> builder
                        .visit(Advice.to(BigIntegerAdvice.class)
                                .on(ElementMatchers.named("oddModPow"))))
                .installOn(inst);
        // 使得软件无法联查询license是否有效
        agentBuilder.type(ElementMatchers.named("sun.net.www.http.HttpClient"))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) -> builder
                        .visit(Advice.to(HttpClientAdvice.class)
                                .on(ElementMatchers.named("openServer"))))
                .installOn(inst);

    }
}
