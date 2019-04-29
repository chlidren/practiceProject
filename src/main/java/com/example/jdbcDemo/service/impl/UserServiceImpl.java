package com.example.jdbcDemo.service.impl;

import com.example.jdbcDemo.bean.User;
import com.example.jdbcDemo.dao.UserDao;
import com.example.jdbcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/25 17:19
 */

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userDao.update(id, user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User addOneUser(Integer id) {
        return userDao.addOneUser(id);
    }
}
