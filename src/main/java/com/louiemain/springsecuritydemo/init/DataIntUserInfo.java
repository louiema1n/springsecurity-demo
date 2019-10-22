package com.louiemain.springsecuritydemo.init;

import com.louiemain.springsecuritydemo.domain.UserInfo;
import com.louiemain.springsecuritydemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @ClassName DataIntUserInfo
 * @Description 数据初始化-用户信息
 * @Author louiema1n
 * @Date 2019/10/22 17:26
 **/
@Service
public class DataIntUserInfo {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dataInit() {
        UserInfo admin = new UserInfo();
        admin.setUsername("admin");
        admin.setPassword(this.passwordEncoder.encode("123456"));
        admin.setRoles(UserInfo.Role.admin);
        this.userInfoRepository.save(admin);

        UserInfo user = new UserInfo();
        user.setUsername("user");
        user.setPassword(this.passwordEncoder.encode("111111"));
        user.setRoles(UserInfo.Role.normal);
        this.userInfoRepository.save(user);
    }
}