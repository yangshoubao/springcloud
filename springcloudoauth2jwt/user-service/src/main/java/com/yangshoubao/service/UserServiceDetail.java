package com.yangshoubao.service;

import com.yangshoubao.dao.UserDao;
import com.yangshoubao.dto.Jwt;
import com.yangshoubao.dto.UserLoginDTO;
import com.yangshoubao.exception.UserLoginException;
import com.yangshoubao.model.User;
import com.yangshoubao.util.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail {

    @Autowired
    private UserDao userDao;

    @Autowired
    AuthServiceClient client;

    public UserLoginDTO login(String username, String password){
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password, user.getPassword())){
            throw new UserLoginException("error password");
        }
        Jwt jwt = client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password", username, password);
        if (jwt == null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;
    }

    public User insertUser(User user) {
        user.setPassword(BPwdEncoderUtil.BCryptPassword(user.getPassword()));
        return userDao.save(user);
    }
}
