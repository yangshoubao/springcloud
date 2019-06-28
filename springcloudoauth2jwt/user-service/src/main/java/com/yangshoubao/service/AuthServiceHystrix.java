package com.yangshoubao.service;

import com.yangshoubao.dto.Jwt;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient {

    @Override
    public Jwt getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
