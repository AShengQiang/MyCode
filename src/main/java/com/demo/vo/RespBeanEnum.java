package com.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RespBeanEnum {
    //通用
    SUCESS(200,"SUCESS"),
    ERROR(500,"SEVER EXCEPTION"),

    //登录错误码
    LOGIN_USER_ERROR(500210,"用户名不存在，请先注册"),
    LOGIN_PASSWORD_ERROR(500210,"用户名或者密码错误"),
    MOBILE_ERROR(500211,"手机号码格式错误"),

    //参数校验异常
    BIND_ERROR(500212,"登录参数校验异常");

    private final Integer code;
    private final String message;
}
