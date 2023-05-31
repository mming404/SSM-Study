package com.ysm.mybatis.mapper;

import com.ysm.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser();

    int updateUser();

    int deleteUser();

    User getUserById();

    User getUserByName(@Param(value = "name") String name);

    List<User> listAllUser();

    int addUser(User user);

    Integer getUsersCount();

    Map<String,Object> getUserById2(@Param(value = "id") Integer id);


}
