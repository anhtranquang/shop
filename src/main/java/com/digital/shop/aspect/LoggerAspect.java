package com.digital.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Aspect
@Configuration
public class LoggerAspect {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Before("within(com.ascendmoney.ami.agent..*) && @annotation(LogAround)")
    public void writeLogBefore(JoinPoint joinPoint) throws Throwable {
        LOGGER.info("===== Start: " + this.getMessage(joinPoint) + " =====");
    }

    @AfterReturning("within(com.ascendmoney.ami.agent..*) && @annotation(LogAround)")
    public void writeLogAfterReturn(JoinPoint joinPoint) throws Throwable {
        LOGGER.info("===== End with success: " + this.getMessage(joinPoint) + " =====");
    }

    @AfterThrowing(value = "within(com.ascendmoney.ami.agent..*) && @annotation(LogAround)", throwing="e")
    public void writeLogAfterThrow(JoinPoint joinPoint, Exception e) throws Throwable {
        LOGGER.error("There is an error occur in process", e);
        LOGGER.info("===== End with failure: " + this.getMessage(joinPoint) + " =====");
    }

    private String getMessage(JoinPoint joinPoint) throws Throwable {
        Method interfaceMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Method implementationMethod = joinPoint.getTarget().getClass().getMethod(interfaceMethod.getName(), interfaceMethod.getParameterTypes());

        String message = null;
        if (implementationMethod.isAnnotationPresent(LogAround.class)) {
            LogAround logAround = implementationMethod.getAnnotation(LogAround.class);
            message = logAround.message();
        }

        return message;
    }

}
