package com.demo.controller;

import com.demo.service.UserService;
import com.demo.vo.LoginVo;
import com.demo.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@RequestMapping("/web/login")
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(HttpServletRequest request, HttpServletResponse response, @Valid LoginVo loginVo){
        log.info("param:{}",loginVo);
        return userService.doLogin(request,response,loginVo);
    }

}
