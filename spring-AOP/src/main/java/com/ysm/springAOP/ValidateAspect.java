package com.ysm.springAOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //优先级 越小越优先
public class ValidateAspect {

    @Before("execution(* com.ysm.springAOP.CalculatorImpl.*(..))")
    public void beforeMethod(){

    }
}
