package com.zhangtuzi.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangtuzi.study.dto.request.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
public class DemoController {
    @RequestMapping(value = "/query1")
    public JSONObject query1(@RequestBody LoginRequest request) {
        return JSONObject.parseObject(JSONObject.toJSONString(request));
    }

    @RequestMapping(value = "/query2")
    public JSONObject query2(LoginRequest request) {
        return JSONObject.parseObject(JSONObject.toJSONString(request));
    }

    @RequestMapping(value = "/query3")
    public JSONObject query3(@RequestBody LoginRequest request) throws Exception {
        throw new Exception("异常测试");
    }

    @RequestMapping(value = "/query4")
    public JSONObject query4(LoginRequest request) throws Exception {
        throw new Exception("异常测试");
    }
}
