package com.louiemain.springsecuritydemo.domain;

import javax.persistence.*;

/**
 * @ClassName UserInfo
 * @Description 用户信息
 * @Author louiema1n
 * @Date 2019/10/22 17:08
 **/
@Entity
public class UserInfo {

    /**
     * 角色枚举值
     */
    public enum Role {
        admin, normal
    }

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue
    private long uid;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role roles;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }
}