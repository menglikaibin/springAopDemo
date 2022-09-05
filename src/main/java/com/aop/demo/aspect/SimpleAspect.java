package com.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {

    // 定义切入点表达式
    @Pointcut("execution(* com.aop.demo.service..*.*(..))")
    private void pointcut() {

    }

    // 环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("执行" + methodName + "的环绕通知(@Around)开始。。。");
        try {
            long startTime = System.currentTimeMillis();
            // 执行目标方法
            Object result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            System.out.println(methodName + "()方法耗时:" + (endTime - startTime) + "毫秒");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new Exception("方法执行异常");
        }
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行" + methodName + "的前置通知(@Before)。。。");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行" + methodName + "的后置通知(@After)。。。");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行" + methodName + "的后置通知(@AfterReturning)。。。");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行" + methodName + "的异常返回通知(@AfterThrowing)。。。");
    }
}
