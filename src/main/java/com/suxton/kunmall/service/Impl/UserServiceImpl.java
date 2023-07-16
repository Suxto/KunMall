package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.OrdersMapper;
import com.suxton.kunmall.dao.UserMapper;
import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.pojo.UserExample;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrdersMapper ordersMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void createUser(String name, String password) {
        User user = new User();
        user.setUsername(name);
        user.setPasswd(bCryptPasswordEncoder.encode(password));
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
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) return null;
        else return users.get(0);
    }
@Override
    public void createOrder(Orders order) {
        ordersMapper.insert(order);
    }
}
