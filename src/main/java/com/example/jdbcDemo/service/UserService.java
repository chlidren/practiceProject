package com.example.jdbcDemo.service;

import com.example.jdbcDemo.bean.User;

import java.util.List;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/25 17:18
 */

public interface UserService {
    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);

    User addOneUser(Integer id);
}
