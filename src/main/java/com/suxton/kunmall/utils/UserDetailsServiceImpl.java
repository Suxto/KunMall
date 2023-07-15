package com.suxton.kunmall.utils;

import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.utils.MyUserDetails;
import com.suxton.kunmall.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username.");
        }
        List<GrantedAuthority> authorities = buildAuthorities(user.getIsadmin());
        return new MyUserDetails(user.getId(), user.getUsername(), user.getPasswd(), user.getIsadmin(),
                authorities);
    }

    private List<GrantedAuthority> buildAuthorities(boolean isAdmin) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (isAdmin) {
            authorities.add(new SimpleGrantedAuthority("ROLE_admin"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_user"));
        }
        return authorities;
    }

}
