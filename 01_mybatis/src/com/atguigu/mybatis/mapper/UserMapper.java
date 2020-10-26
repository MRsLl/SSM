package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User queryById(Integer id);

    List<User> queryUsers();

    int saveUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);

    @MapKey("id")
    List<User> queryUsersForMap(Map<String,Object> paramMap);
}
