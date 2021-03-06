package com.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
    public void getConnTest(){
        SqlSession sqlSession=MybatisUtil.createSqlSession();
        if(sqlSession!=null){
            System.out.println("连接成功");
        }
        MybatisUtil.closeSqlSession(sqlSession); }
}