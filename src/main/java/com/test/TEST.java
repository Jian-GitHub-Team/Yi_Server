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
    public Object select(){
        String url = "http://localhost:8081/user/select";
        System.out.println("请求url:" + url);
        String result = "null";
        try {
            result = HttpClientUtil.doGet(url);
            System.out.println("请求结果：" + result);
            System.out.println("===============");
            //转化为list
            List<User> list2 = JsonUtils.jsonToList(result,User.class);

            System.out.println(list2);

            for (User stu : list2) {
                System.out.println("这是"+stu.getUserName());
            }
//            System.out.println(JsonUtils.toJson(result));
            System.out.println("===============");
//            System.out.println(JsonUtils.toJson(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return result;
        return JsonUtils.toJson(result);
    }
}
