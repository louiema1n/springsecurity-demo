package com.louiemain.springsecuritydemo.init;

import com.louiemain.springsecuritydemo.domain.Role;
import com.louiemain.springsecuritydemo.domain.UserInfo;
import com.louiemain.springsecuritydemo.repository.RoleRepository;
import com.louiemain.springsecuritydemo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void dataInit() {
        List<Role> roles = new ArrayList<>();
        Role adminRole = new Role("admin", "管理员");
        this.roleRepository.save(adminRole);
        Role userRole = new Role("normal", "普通用户");
        this.roleRepository.save(userRole);
        roles.add(adminRole);
        roles.add(userRole);

        UserInfo admin = new UserInfo();
        admin.setUsername("admin");
        admin.setPassword(this.passwordEncoder.encode("123456"));
        admin.setRoles(roles);
        this.userInfoRepository.save(admin);

        roles = new ArrayList<>();
        roles.add(userRole);
        UserInfo user = new UserInfo();
        user.setUsername("user");
        user.setPassword(this.passwordEncoder.encode("111111"));
        user.setRoles(roles);
        this.userInfoRepository.save(user);
    }
}