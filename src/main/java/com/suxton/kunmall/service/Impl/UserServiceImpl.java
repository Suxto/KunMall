package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.UserMapper;
import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.pojo.UserExample;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public boolean verifyUser(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(user.getUsername()).andPasswdEqualTo(user.getPasswd());
        int num = (int) userMapper.countByExample(userExample);
        return num != 0;
    }

}
