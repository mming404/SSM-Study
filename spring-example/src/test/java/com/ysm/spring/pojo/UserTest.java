package com.ysm.spring.pojo;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

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

    @Test
    public void testIOC2() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) ioc.getBean("user");
//
        final DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);

        System.out.println(dataSource.getConnectCount());
    }

    @Test
    public void testIOCByAnnotation() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) ioc.getBean("user");
//
        final VipUser vipUser = ioc.getBean(VipUser.class);
        System.out.println(vipUser.getUser().toString());

    }
}
