package com.controller;

import com.entity.User;
import com.mapper.UserMapper;
import com.untils.HttpClientUtil;
import com.untils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import net.sf.json.JSONObject;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("select")
    public List<User> selectUsers() {
//        System.out.println(userMapper.select());
        return userMapper.select();
    }
}

