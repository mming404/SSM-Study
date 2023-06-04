package com.ysm.springAOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void testAop1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Calculator calculator = ioc.getBean(Calculator.class);
        final int sub = calculator.sub(4, 1);
        System.out.println(sub);
    }
}
