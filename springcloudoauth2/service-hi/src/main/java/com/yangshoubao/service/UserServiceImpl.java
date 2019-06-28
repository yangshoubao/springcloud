package com.yangshoubao.service;

import com.yangshoubao.dao.UserDao;
import com.yangshoubao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserDao userDao;

    @Override
    public User create(User user) {
        String hah = encoder.encode(user.getPassword());
        user.setPassword(hah);
        return userDao.save(user);
    }
}
