package com.zhangxuan.text1.service;


import com.zhangxuan.text1.entities.Users;


/**
 * @author Administrator
 */
public interface UsersService {

    Users findByUsername(String username) ;

    Users login(String username,String password);
}
