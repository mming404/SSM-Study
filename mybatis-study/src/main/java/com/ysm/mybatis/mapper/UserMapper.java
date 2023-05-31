package com.ysm.mybatis.mapper;

import com.ysm.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();

    int updateUser();
    int deleteUser();
    User getUserById();

    List<User> listAllUser();
}
