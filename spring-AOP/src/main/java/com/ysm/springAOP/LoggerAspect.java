package com.ysm.springAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect //标记为切面
public class LoggerAspect {


    //切入点表达式的复用
    @Pointcut("execution(* com.ysm.springAOP.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点对应方法名
        final Signature signature = joinPoint.getSignature();

        //获取连接点对应的参数列表
        final Object[] args = joinPoint.getArgs();
        System.out.println("前置通知：方法：" + signature.getName() + ", 参数: " + Arrays.toString(args));
    }


    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        System.out.println("后置通知: 执行完毕!");
    }

    //返回通知
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知: 结果 " + result.toString());
    }

    //异常通知
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable e) {


    }


    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前");
            //目标方法的执行，目标方法的返回值一定要返回给外界调用者
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }
}
