package com.hlieb;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aspect logging configuration
 */
@Configuration
@EnableAspectJAutoProxy
@Aspect
public class LoggingAspectConfig {

    @Pointcut("within(com.hlieb.*.*.*)")
    public void serviceAnnotation() {
        // stub
    }

    @Pointcut("serviceAnnotation()")
    public void customizableTrace() {
        // stub
    }

    @Bean
    public CustomizableTraceInterceptor customizableTraceInterceptor() {
        final CustomizableTraceInterceptor customizableTraceInterceptor = new LoggingInterceptor();
        customizableTraceInterceptor.setUseDynamicLogger(true);
        customizableTraceInterceptor.setEnterMessage("ENTERING $[targetClassShortName].$[methodName]($[arguments])");
        customizableTraceInterceptor
                .setExitMessage("EXITING  $[targetClassShortName].$[methodName](), returned $[returnValue]");
        return customizableTraceInterceptor;
    }

    @Bean
    public Advisor customizableTraceAdvisor() {
        final AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.hlieb.LoggingAspectConfig.customizableTrace()");
        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
    }

}