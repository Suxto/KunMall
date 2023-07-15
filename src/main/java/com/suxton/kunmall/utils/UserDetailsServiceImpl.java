package com.suxton.kunmall.utils;

import com.suxton.kunmall.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.suxton.kunmall.pojo.User user = userService.getUserByName(username);
        if (user == null) return null;
        UserDetails userDetails = null;


        userDetails = User.builder().username(username)
                .password(user.getPasswd())
                .authorities(user.getIsadmin() ? "user" : "admin")
                .build();
        return userDetails;
    }
}
