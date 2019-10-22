package com.louiemain.springsecuritydemo.config;

import com.louiemain.springsecuritydemo.domain.UserInfo;
import com.louiemain.springsecuritydemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomUserDetailService
 * @Description 自定义用户信息验证及鉴权
 * @Author louiema1n
 * @Date 2019/10/22 17:19
 **/
@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("CustomUserDetailService.loadUserByUsername()");
        // 通过username获取用户信息
        UserInfo userInfo = this.userInfoService.findByUsername(s);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 定义权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 添加用户权限
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userInfo.getRoles().name()));

        // 验证
        return new User(userInfo.getUsername(),
                userInfo.getPassword(),
                authorities);
    }
}