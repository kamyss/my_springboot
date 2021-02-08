package com.zjh.springboot.demo.dao;

import com.zjh.springboot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

}
