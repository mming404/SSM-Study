package com.ysm.mybatis.mapper;

import com.ysm.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    List<User> getUserLike(@Param("name") String name);

    void deleteMoreUser(@Param("ids") String ids);

    void insertUserGetKey(User user);
}
