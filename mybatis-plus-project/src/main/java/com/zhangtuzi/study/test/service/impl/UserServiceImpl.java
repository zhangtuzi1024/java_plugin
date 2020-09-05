package com.zhangtuzi.study.test.service.impl;

import com.zhangtuzi.study.test.entity.User;
import com.zhangtuzi.study.test.mapper.UserMapper;
import com.zhangtuzi.study.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangtuzi
 * @since 2020-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
