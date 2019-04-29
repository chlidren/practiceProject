package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.bean.User;
import com.example.MyBatisDemo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/29 15:37
 */
@RestController
@RequestMapping
public class MyUserController {
    @Autowired
    private MyUserService userService;

    @RequestMapping(value = "/myuser/{id}", method = RequestMethod.GET)
    public void getUser(@PathVariable("id") Integer id) {
        User user=userService.findUser(id);
        System.out.println(user);
    }
}
