package com.yangshoubao.dto;

import com.yangshoubao.model.User;

public class UserLoginDTO {

    private Jwt jwt;

    private User user;

    public Jwt getJwt() {
        return jwt;
    }

    public void setJwt(Jwt jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
