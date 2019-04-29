package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/21 22:50
 */

@RestController
public class HelloController {

    @RequestMapping(value = "hello",method = RequestMethod.GET )
    public String hello(){
        return "hello world6";
    }
}
