package com.zhangtuzi.study;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.zhangtuzi.study.dto.request.LoginRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class SampleTest {


    @Test
    public void testAop() throws Exception {
        LoginRequest body = new LoginRequest();
        body.setName("张三");
        body.setPwd("xxx");
        Map<String, Object> form = new HashMap<>();
        form.put("name", "张三");
        form.put("pwd", "xxx");
        HttpUtil.post("http://127.0.0.1:8080/demo/query1", JSONObject.toJSONString(body));
        HttpUtil.post("http://127.0.0.1:8080/demo/query2", form);
        HttpUtil.get("http://127.0.0.1:8080/demo/query2?name=张三&pwd=xxx");
        HttpUtil.post("http://127.0.0.1:8080/demo/query3", JSONObject.toJSONString(body));
        HttpUtil.post("http://127.0.0.1:8080/demo/query4", form);
        HttpUtil.get("http://127.0.0.1:8080/demo/query4?name=张三&pwd=xxx");
    }

}
