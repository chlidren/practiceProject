package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/29 15:36
 */
@Repository
public interface UserMapper {
    User findUser(Integer id);
}
