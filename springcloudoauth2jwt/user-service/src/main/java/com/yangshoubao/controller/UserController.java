package com.yangshoubao.controller;

import com.yangshoubao.dto.UserLoginDTO;
import com.yangshoubao.model.User;
import com.yangshoubao.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceDetail userServiceDetail;

    @PostMapping("/register")
    public User register(@RequestParam("username") String username, @RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userServiceDetail.insertUser(user);
    }

    @PostMapping("/login")
    public UserLoginDTO login(@RequestParam("username") String username, @RequestParam("password") String password){
        return userServiceDetail.login(username, password);
    }
}
