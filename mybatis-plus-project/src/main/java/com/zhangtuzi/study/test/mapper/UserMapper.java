package com.zhangtuzi.study.test.mapper;

import com.zhangtuzi.study.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhangtuzi
 * @since 2020-09-05
 */
public interface UserMapper extends BaseMapper<User> {

    List<Map> selectUserFull();
}
