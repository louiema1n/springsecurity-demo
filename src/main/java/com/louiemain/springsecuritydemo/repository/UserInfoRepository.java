package com.louiemain.springsecuritydemo.repository;

import com.louiemain.springsecuritydemo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserInfoRepository
 * @Description 用户信息
 * @Author louiema1n
 * @Date 2019/10/22 17:14
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}