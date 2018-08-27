package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aop {
    //可以配置多个切点
    @Pointcut("execution(* com.example.demo.aop.mytarget.*(..))")// the pointcut expression
    private void anyOldTransfer() {}// the pointcut signature
    @Before("anyOldTransfer()")
    public void nihao(){
        System.out.println("你好+++");
    }
}
