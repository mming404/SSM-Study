package com.ysm.spring.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testIOC() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) ioc.getBean("user");
        final User user = ioc.getBean("user",User.class);

        user.sayHello();
    }

    @Test
    public void testIOC1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) ioc.getBean("user");
//
        final VipUser vipUser = ioc.getBean(VipUser.class);
        System.out.println(vipUser.toString());


    }
}
