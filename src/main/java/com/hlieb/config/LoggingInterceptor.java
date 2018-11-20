package com.hlieb;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * Aspect logging configuration
 */
public class LoggingInterceptor extends CustomizableTraceInterceptor {

    @Override
    protected void writeToLog(final Log logger, final String message, final Throwable ex) {
        if (ex != null) {
            logger.error(message, ex);
        } else {
            logger.info(message);
        }
    }

    @Override
    protected boolean isInterceptorEnabled(final MethodInvocation invocation, final Log logger) {
        return true;
    }

}