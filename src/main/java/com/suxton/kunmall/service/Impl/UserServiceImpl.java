package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.OrdersMapper;
import com.suxton.kunmall.dao.UserConsumedMapper;
import com.suxton.kunmall.dao.UserMapper;
import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.pojo.OrdersExample;
import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.pojo.UserExample;
import com.suxton.kunmall.service.UserService;
import com.suxton.kunmall.pojo.UserConsumed;
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
    @Resource
    private UserConsumedMapper userConsumedMapper;

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

    @Override
    public List<Orders> getUserOrderList(int id) {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.or().andUseridEqualTo(id);
        ordersExample.setOrderByClause("orderTime DESC");
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public List<UserConsumed> getUserConsumed() {
        return userConsumedMapper.getUsersConsumed();
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public void changeRole(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setIsadmin(!user.getIsadmin());
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void updatePassword(int id, String password) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setPasswd(bCryptPasswordEncoder.encode(password));
        userMapper.updateByPrimaryKey(user);
    }
}
