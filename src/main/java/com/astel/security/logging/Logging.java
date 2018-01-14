package com.astel.security.logging;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j
public class Logging {
    @After("target(com.astel.security.SecuredService)")
    public Object securedMethodsLogging(ProceedingJoinPoint pjp) throws Throwable {
        Object retVal = pjp.proceed();
        log.info(pjp.getTarget().getClass().getName() + " " + pjp.getSignature().getName());
        return retVal;
    }
}