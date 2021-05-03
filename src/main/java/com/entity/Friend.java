package com.entity;
/**
 * 好友类
 * @author Qi
 * @Date 2021/5/3 8:25 下午
 */

import lombok.Data;

@Data
public class Friend {
    private int id;
    private String userName;//用户名称
//    private String password;//密码
//    private String createDate;//创建时间
//    private String lastDate;//最后登录时间
    private boolean isOnLine;//是否在线
    private boolean isAvatar;//是否有头像
}