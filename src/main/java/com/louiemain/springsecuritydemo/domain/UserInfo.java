package com.louiemain.springsecuritydemo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName UserInfo
 * @Description 用户信息
 * @Author louiema1n
 * @Date 2019/10/22 17:08
 **/
@Entity
public class UserInfo {

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue
    private long uid;

    private String username;
    private String password;

    // 多对多，立即加载
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}