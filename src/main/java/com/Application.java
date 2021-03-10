package com;


import com.controller.UserController;
import com.mapper.UserMapper;
import com.test.Listener_Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//Jian
@SpringBootApplication
public class Application {

    private static UserMapper userMapper;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            //            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //设置允许跨域请求的域名
                        .allowedOrigins("*")
                        //是否允许证书 不再默认开启
                        .allowCredentials(true)
                        //设置允许的方法
                        .allowedMethods("*")
                        //跨域允许时间
                        .maxAge(3600);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
