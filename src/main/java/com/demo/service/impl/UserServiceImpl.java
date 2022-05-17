package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.exception.GlobalException;
import com.demo.pojo.User;
import com.demo.service.UserService;
import com.demo.utils.CookieUtil;
import com.demo.utils.MD5Util;
import com.demo.utils.RedisUtil;
import com.demo.utils.UUIDUtil;
import com.demo.vo.LoginVo;
import com.demo.vo.RespBean;
import com.demo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public RespBean doLogin(HttpServletRequest request, HttpServletResponse response,LoginVo loginVo) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        //查询数据库
        User user = userDao.finduserById(mobile);

        if(null == user){
            throw new GlobalException(RespBeanEnum.LOGIN_USER_ERROR);
        }

        //判断密码是否正确

        if(!user.getPassword().equals(MD5Util.fromPassToDBPass(password,user.getSalt()))){
           throw new GlobalException(RespBeanEnum.LOGIN_PASSWORD_ERROR);
        }

        String ticket = UUIDUtil.uuid();
        //将user信息存入redis中
        redisUtil.set("user:"+ticket,user);
        //将token存入cookie
        CookieUtil.setCookie(request,response,"UserTicket",ticket);

        return RespBean.success();
    }
}
