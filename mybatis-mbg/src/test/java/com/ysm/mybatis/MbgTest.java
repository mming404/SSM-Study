package com.ysm.mybatis;

import com.github.pagehelper.PageHelper;
import com.ysm.mybatis.mapper.UserMapper;
import com.ysm.mybatis.pojo.User;
import com.ysm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MbgTest {

    @Test
    public void testMbgSQL() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = userMapper.selectByPrimaryKey(8);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testMbgSQL1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1,3);
        final List<User> users = userMapper.selectByExample(null);
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testMbgSQL2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1,3);
        final List<User> users = userMapper.selectByExample(null);
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
