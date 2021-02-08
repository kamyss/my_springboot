package com.zjh.springboot.demo.service;

import com.zjh.springboot.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserSevice {
    List<User> findAll();

    List<User> queryUserByName(String name);

    List<User> queryAll();

    List<User> queryUserByPage(Integer page,Integer rows);
}
