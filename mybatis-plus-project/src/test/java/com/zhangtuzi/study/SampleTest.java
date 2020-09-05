package com.zhangtuzi.study;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangtuzi.study.test.entity.User;
import com.zhangtuzi.study.test.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        //简单查询
        simpleQuery();

        //条件表达式、单条查询、查询部分字段
        mixQuery();

        //分页查询
        pageQuery();

        //自定义查询
        customQuery();
    }

    private void pageQuery() {
        System.out.println("-----分页查询-----");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30).orderByAsc("age");
        IPage<User> users = userMapper.selectPage(new Page<>(1, 2), wrapper);
        System.out.println(JSONObject.toJSONString(users));
    }

    private void mixQuery() {
        System.out.println("-----条件表达式、单条查询、查询部分字段-----");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("email").eq("name", "Sandy");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    private void simpleQuery() {
        System.out.println("-----简单查询-----");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    private void customQuery() {
        System.out.println("-----自定义查询-----");
        List<Map> users = userMapper.selectUserFull();
        users.forEach(System.out::println);
    }
}
