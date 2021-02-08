package com.zjh.springboot.demo.controller;

import com.github.pagehelper.PageHelper;
import com.zjh.springboot.demo.entity.User;
import com.zjh.springboot.demo.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("user")
//@ResponseBody
public class UserController {

    @Autowired
    private UserSevice userService;

    public List<User> queryAllUser(){
        List<User> list=this.userService.findAll();
        return list;
    }

    @RequestMapping("list/{name}")
    public List<User> queryUserByName(@PathVariable String name){
        System.out.println(name);
        List<User> list=this.userService.queryUserByName(name);
        return list;
    }

    //获取全部用户的列表

    @RequestMapping("list/all")
    public List<User> queryAll(){
        List<User> list=this.userService.queryAll();
        System.out.println(Arrays.toString(list.toArray()));
        for(User u : list){
            System.out.println(u.getName());
        }
        //输出自己为什么会转驼峰。
        return list;
    }

    @RequestMapping("list/allpage/{page}/{rows}")
    public List<User> queryUserByPage(@PathVariable Integer page,@PathVariable Integer rows){
        //设置分页
        PageHelper.startPage(page,rows);
        List<User> list=this.userService.queryUserByPage(page,rows);
        return list;
    }

}
