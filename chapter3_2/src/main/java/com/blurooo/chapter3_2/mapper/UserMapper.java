package com.blurooo.chapter3_2.mapper;

import com.blurooo.chapter3_2.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT * FROM users WHERE username=#{username}")
    User findByUserName(@Param("username") String username);

}
