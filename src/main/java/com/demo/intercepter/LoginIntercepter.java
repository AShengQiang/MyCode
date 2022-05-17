package com.demo.intercepter;

import com.demo.pojo.User;
import com.demo.utils.CookieUtil;
import com.demo.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginIntercepter implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userTicket = CookieUtil.getCookieValue(request, "UserTicket");

        if(StringUtils.isBlank(userTicket)){
            response.sendRedirect("/login/tologin");
            return false;
        }
        //从redis中获取user
        RedisUtil redisUtil = new RedisUtil();
        String key ="user:d465a6b8b5004b7cbb4d44b57f6f082e";
        User user = (User)redisUtil.get(key);

        if(null==user){
            response.sendRedirect("/login/tologin");
            return false;
        }
        request.setAttribute("user",user);
        return true;
    }
}
