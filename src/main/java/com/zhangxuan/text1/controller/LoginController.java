package com.zhangxuan.text1.controller;

import com.zhangxuan.text1.entities.Users;
import com.zhangxuan.text1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class LoginController {


    UsersService usersService;
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        Users byUsername = usersService.login(username, password);

        if(byUsername==null){
            map.put("msg","用户名或密码错误11");
            return "login";
        }
        if(!byUsername.getUsername().equals(username)){
            map.put("msg","用户名或密码错误22");
            return "login";
        }
        if(!byUsername.getPassword().equals(password)){
            map.put("msg","用户名或密码错误33");
            return "login";
        }
        session.setAttribute("loginUser", username);
        return  "redirect:/main.html";
    }


}
