package com.example.jdbcDemo.controller;

import com.example.jdbcDemo.bean.JsonResult;
import com.example.jdbcDemo.bean.User;
import com.example.jdbcDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Zachery Qiu
 * @Date: 2019/3/25 17:30
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList() {
        JsonResult r = new JsonResult();
        try {
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String add( User user) {
        try {
            int orderId = userService.add(user);
            if (orderId < 0) {
                System.out.println("good");
                return "good";
            } else {
                System.out.println("bad");
                return "bad";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "worst";
        }
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(id);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update(@PathVariable("id") Integer id, @RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            int ret = userService.update(id, user);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }



    @RequestMapping(value="oneUser/{id}",method = RequestMethod.GET)
    public void addOneUser(@PathVariable("id") Integer id){
        User user=userService.addOneUser(id);
        System.out.println(user);
    }
}
