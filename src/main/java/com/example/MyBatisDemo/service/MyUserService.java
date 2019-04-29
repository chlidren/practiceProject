package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.bean.User;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/29 15:36
 */
public interface MyUserService {
    User findUser(Integer id);
}
