package com.controller;

import com.entity.Friend;
import com.entity.User;
import com.mapper.Friend_Mapper;
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
import java.util.List;

@RestController
@RequestMapping("Yi/Friend")
public class Friend_Controller {
    @Autowired
    Friend_Mapper friend_mapper;

    /**
     * 传入用户名，寻得并以Base64编码返回该用户密码
     * @param ID 用户名
     * @return String Base64编码后的用户密码，若发生异常则返回空字符串。
     */
//    @RequestMapping(
////            method = {RequestMethod.POST},
//            value ="/selectFriendsByID"
//    )
    @RequestMapping("/selectFriendsByID")
    public String login(@RequestParam("ID") int ID){
        try {
            return Base64Util.encode(JsonUtils.toJson(friend_mapper.selectFriendsByID(ID)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
