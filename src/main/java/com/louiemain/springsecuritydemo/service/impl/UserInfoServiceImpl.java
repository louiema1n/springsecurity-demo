package com.louiemain.springsecuritydemo.service.impl;

import com.louiemain.springsecuritydemo.domain.UserInfo;
import com.louiemain.springsecuritydemo.repository.UserInfoRepository;
import com.louiemain.springsecuritydemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserInfoServiceImpl
 * @Description 用户信息服务实现类
 * @Author louiema1n
 * @Date 2019/10/22 17:17
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        return this.userInfoRepository.findByUsername(username);
    }
}