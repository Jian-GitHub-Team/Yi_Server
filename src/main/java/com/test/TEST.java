package com.test;

import com.entity.User;
import com.untils.HttpClientUtil;
import com.untils.JsonUtils;
import net.sf.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userselect")
public class TEST {
    @RequestMapping("select")
    public static <T> List<T> select(Class<T> clazz) {
        String url = "http://localhost:8081/user/select";
//        System.out.println("请求url:" + url);
        String result = "null";
        try {
            result = HttpClientUtil.doGet(url);
//            System.out.println("请求结果：" + result);
//            System.out.println("===============");
//            //转化为list
//            List<User> list2 = JsonUtils.jsonToList(result,User.class);

//            System.out.println(list2);
            return JsonUtils.jsonToList(result, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("TTT")
    public void ttt(){
        new Listener_Test().lTest();
    }
}
