package com.zjh.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjh.springboot.demo.dao.UserDao;
import com.zjh.springboot.demo.entity.User;
import com.zjh.springboot.demo.mapper.UserMapper;
import com.zjh.springboot.demo.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserSevice {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value="userCache",key="user.findAll")
    public List<User> findAll(){
        List<User> list=this.userDao.findAll();
        return list;
    }

    @Override
    public List<User> queryUserByName(String name){
        List<User> list=this.userMapper.queryUserByName(name);
        return list;
    }

    public List<User> queryAll(){
        List<User> list=this.userMapper.queryAll();
        return list;
    }

    public List<User> queryUserByPage(Integer page,Integer rows){
        //设置分页
        PageHelper.startPage(page,rows);
        List<User> list=this.userMapper.select(null);
        return list;
    }
}
