package com.ysm.mybatis.mapper;

import com.ysm.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    List<User> getUserByCondition(User user);

    /**
     * 批量添加
     */
    void insertMoreUser(@Param("users") List<User> users);

    void deleteMoreUser(@Param("userIds") Integer[] userIds);
}
