package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.UserMapper;
import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.pojo.UserExample;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.utils.CommonUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public void createUser(String name, String password) {
        User user = new User();
        user.setUsername(name);
        user.setPasswd(password);
        user.setIsadmin(false);
        userMapper.insert(user);
    }

    @Override
    public boolean verifyUser(String name, String password) {
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(name).andPasswdEqualTo(password);
        int num = (int) userMapper.countByExample(userExample);
        return num != 0;
    }

    @Override
    public boolean hasUser(String name) {
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(name);
        return 0 != userMapper.countByExample(userExample);
    }

    @Override
    public User getUserByName(String name) {
        UserExample userExample = new UserExample();
        userExample.or().andUsernameEqualTo(name);
        try {
            return userMapper.selectByExample(userExample).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
