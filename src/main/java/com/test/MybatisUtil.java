package com.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    static {
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            //引用指向由SqlSessionBuilder类对象调用build方法创建的SqlSession工厂类对象
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession对象
    public static SqlSession createSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //关闭sqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}