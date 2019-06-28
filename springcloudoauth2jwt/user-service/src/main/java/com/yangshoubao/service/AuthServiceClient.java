package com.yangshoubao.service;

import com.yangshoubao.dto.Jwt;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "uaa-service")
public interface AuthServiceClient {

    @PostMapping(value = "/oauth/token")
    Jwt getToken(@RequestHeader(value = "Authorization") String authorization,
                 @RequestParam("grant_type") String grant_type,
                 @RequestParam("username") String username,
                 @RequestParam("password") String password);
}
