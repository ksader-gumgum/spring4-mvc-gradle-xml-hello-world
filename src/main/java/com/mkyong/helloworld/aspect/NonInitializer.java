package com.mkyong.helloworld.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Not a javadoc comment.
 * @author GumGum
 */
@Aspect
public class NonInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(NonInitializer.class);

    @Around("afterPropertiesSetJP() || titleJP()")
    public Object doNothing(ProceedingJoinPoint pjp) {
        LOG.info("Doing nothing {}", pjp.getStaticPart());
        return pjp.getStaticPart().toString();
    }

    @Pointcut("execution(* com.mkyong.helloworld.service.*.afterPropertiesSet(..))")
    public void afterPropertiesSetJP() {

    }

    @Pointcut("execution(* com.mkyong.helloworld.service.*.getTitle(..))")
    public void titleJP() {

    }
}
