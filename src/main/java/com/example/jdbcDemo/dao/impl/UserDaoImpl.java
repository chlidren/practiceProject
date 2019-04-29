package com.example.jdbcDemo.dao.impl;

import com.example.jdbcDemo.bean.User;
import com.example.jdbcDemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/25 17:07
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(Integer id) {
        List<User> list = jdbcTemplate.query("select * from tb_user where id = ?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> list = jdbcTemplate.query("select * from tb_user", new Object[]{}, new BeanPropertyRowMapper(User.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into tb_user(username, age, ctm) values(?, ?, ?)",
                user.getUsername(), user.getAge(), new Date());
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("UPDATE tb_user SET username = ? , age = ? WHERE id=?",
                user.getUsername(), user.getAge(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE from tb_user where id = ? ", id);
    }


    @Override
    public User addOneUser(Integer id) {
        //jdbc获取多个用户信息的常用方法
        List<Map<String, Object>> list=jdbcTemplate.queryForList("select * from tb_user where id in (?,?,?)",1,2,3);
        System.out.println(list);
        List<User> users=jdbcTemplate.query("select * from tb_user where id in (?,?,?)",new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setAge(resultSet.getInt("age"));
                user.setCtm(resultSet.getDate("ctm"));
                return user;
            }
        }
        ,1,2,3);
        System.out.println(users);

            return jdbcTemplate.queryForObject("select * from tb_user where id=1", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setAge(resultSet.getInt("age"));
                user.setCtm(resultSet.getDate("ctm"));
                System.out.println(i);
                return user;
            }
        });
    }
}
