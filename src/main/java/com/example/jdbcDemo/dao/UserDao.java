package com.example.jdbcDemo.dao;

import com.example.jdbcDemo.bean.User;

import java.util.List;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/25 16:11
 */
public interface UserDao {
    User getUserById(Integer id);

    public List<User> getUserList();

    public int add(User user);

    public int update(Integer id, User user);

    public int delete(Integer id);
    //仅查询一个人的数据信息
    User addOneUser(Integer id);
}
