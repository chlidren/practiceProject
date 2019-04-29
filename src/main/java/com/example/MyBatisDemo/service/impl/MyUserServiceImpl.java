package com.example.MyBatisDemo.service.impl;

import com.example.MyBatisDemo.bean.User;
import com.example.MyBatisDemo.mapper.UserMapper;
import com.example.MyBatisDemo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/29 15:36
 */
@Service
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(Integer id) {
        User user=userMapper.findUser(id);
        return user;
    }
}
