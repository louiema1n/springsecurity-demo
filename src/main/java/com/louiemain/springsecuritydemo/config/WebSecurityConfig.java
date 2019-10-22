package com.louiemain.springsecuritydemo.config;

import com.louiemain.springsecuritydemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Description webSecurity配置
 * @Author louiema1n
 * @Date 2019/10/22 16:30
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 基于内存的用户认证/鉴权
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(newPasswordEncoder().encode("111111"))
//                .roles("admin");
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(newPasswordEncoder().encode("123456"))
//                .roles("normal");
        // 基于数据库的用户认证/鉴权
        auth.userDetailsService(customUserDetailService).passwordEncoder(newPasswordEncoder());
    }

    /**
     * 注入指定PasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder newPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}