package com.controller;

import com.entity.Login;
import com.entity.User;
import com.mapper.Login_Mapper;
import com.mapper.User_Mapper;
import com.untils.Base64Util;
import com.untils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("Yi/Login")
public class Login_Controller {
    @Autowired
    Login_Mapper login_mapper;
    @Autowired
    User_Mapper user_mapper;

    /**
     * 传入用户名，寻得并以Base64编码返回该用户密码
     * @param userName 用户名
     * @return String Base64编码后的用户密码，若发生异常则返回空字符串。
     */
    @RequestMapping(
            method = {RequestMethod.POST},
            value ="/getPassword"
    )
    public String login(@RequestParam("userName") String userName){
        String result = "";
        try {
//            Login login = login_mapper.selectPasswordByUserName(Base64Util.decode(userName));
            User user = user_mapper.selectUserByName(Base64Util.decode(userName));

            if (user == null){
                return result;
            }
            user.setCreateDate(Base64Util.encode(user.getCreateDate()));
            result = Base64Util.encode(JsonUtils.toJson(user));
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
