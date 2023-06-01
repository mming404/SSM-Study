package com.ysm.mybatis.mapper;

import com.ysm.mybatis.pojo.User;

import java.util.List;

public interface DynamicSQLMapper {
    List<User> getUserByCondition(User user);
}
