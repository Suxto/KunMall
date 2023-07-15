package com.suxton.kunmall.utils;

import com.suxton.kunmall.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private final Integer id;
    private final String username;
    private final String password;
    private final boolean isAdmin;

    private final Collection<? extends GrantedAuthority> authorities;

    // 构造方法

    public MyUserDetails(Integer id, String username, String password, boolean isAdmin, Collection<?
            extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.authorities = authorities;
    }

    // 其他方法

    public Integer id() {
        return id;
    }

    // UserDetails接口的方法实现

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}