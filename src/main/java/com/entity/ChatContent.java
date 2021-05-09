package com.entity;

import lombok.Data;

import java.util.Date;

/**
 * 聊天信息表
 * @author Qi
 * @Date 2021/5/5 2:31 下午
 */
@Data
public class ChatContent {
    private int id;
    private int userID;//发信人id
    private int friendID;//收信人id
    private String content;//聊天内容
    private Date time;//聊天时间
}