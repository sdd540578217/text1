package com.zhangxuan.text1.dao;

import com.zhangxuan.text1.entities.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Mapper
@Repository
public interface UsersDao {
    /**
     * @param username
     * 用户名
     * @return
     */
    @Select("select * from users where username=#{username}")
    Users findByUsername(String username);

    /**
     * @param username
     * 用户名
     * @param password
     * 密码
     * @return
     * 返回一个users对象，用于和数据库校验
     */
    @Select("select * from users where username=#{username} and password=#{password}")
    Users login(@Param("username") String username,@Param("password") String password);
}
