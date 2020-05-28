package com.zhangxuan.text1.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object users = request.getSession().getAttribute("loginUser");
        if(users==null){
            request.setAttribute("msg", "没有权限请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }else {
            return true;
        }

    }
}
