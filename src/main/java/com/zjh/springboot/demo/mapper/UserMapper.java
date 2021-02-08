package com.zjh.springboot.demo.mapper;

import com.zjh.springboot.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends com.github.abel533.mapper.Mapper<User> {
    @Select("select * from user where name like '%${value}%'")
    public List<User> queryUserByName(String name);

    //使用UserMapper.xml配置文件
    public List<User> queryAll();
}
