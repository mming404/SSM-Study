package com.ysm.springAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定当前测试类在spring环境中测试 直接可以通过注入方式获取ioc中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {

    @Test
    public void testAop1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Calculator calculator = ioc.getBean(Calculator.class);
        final int sub = calculator.sub(4, 1);
        System.out.println(sub);
    }
}
