package com.louiemain.springsecuritydemo.service;

import com.louiemain.springsecuritydemo.domain.UserInfo;

/**
 * @ClassName UserInfoService
 * @Description 用户信息服务
 * @Author louiema1n
 * @Date 2019/10/22 17:16
 **/
public interface UserInfoService {

    UserInfo findByUsername(String username);
}