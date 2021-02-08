package com.zjh.springboot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestUserController {
    @RequestMapping("hello")
   // @ResponseBody
    public String hello(){
        return "springboot ok16";
    }
}
