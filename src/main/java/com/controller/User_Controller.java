package com.controller;

import com.entity.User;
import com.mapper.User_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class User_Controller {
    @Autowired
    User_Mapper userMapper;

    @RequestMapping("select")
    public List<User> selectUsers() {
//        System.out.println(userMapper.select());
        return userMapper.select();
    }
}

