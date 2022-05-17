package com.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private Integer code;
    private String  message;
    private Object  object;

    //返回成功对象
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCESS.getCode(),RespBeanEnum.SUCESS.getMessage(),null);
    }

    public static RespBean success(Object obj){
        return new RespBean(RespBeanEnum.SUCESS.getCode(),RespBeanEnum.SUCESS.getMessage(),obj);
    }

    //返回失败对象
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    public static RespBean error(RespBeanEnum respBeanEnum, Object object) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), object);
    }

}
