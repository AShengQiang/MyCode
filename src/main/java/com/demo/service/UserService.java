package com.demo.service;

import com.demo.vo.LoginVo;
import com.demo.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    RespBean doLogin(HttpServletRequest request, HttpServletResponse response,LoginVo loginVo);
}
