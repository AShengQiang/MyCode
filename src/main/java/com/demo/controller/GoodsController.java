package com.demo.controller;

import com.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/web/goods")
public class GoodsController {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @GetMapping("/toList")
    public String toList(HttpServletRequest request, Model model){
        model.addAttribute("user",request.getAttribute("user"));
        return "goodsList";
    }
}
