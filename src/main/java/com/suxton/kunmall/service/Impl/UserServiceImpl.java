package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.OrdersMapper;
import com.suxton.kunmall.dao.ServiceMapper;
import com.suxton.kunmall.dao.UserConsumedMapper;
import com.suxton.kunmall.dao.UserMapper;
import com.suxton.kunmall.pojo.*;
import com.suxton.kunmall.service.UserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private UserConsumedMapper userConsumedMapper;
    @Resource
    private ServiceMapper serviceMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

    @Override
    public String getHelpText(int id, short type) {
        com.suxton.kunmall.pojo.Service service = serviceMapper.selectByPrimaryKey(id);
        if (service == null) return "";
//        logger.warn(service.getStatus()+"");
        service.setStatus((short) (service.getStatus() & type));
        serviceMapper.updateByPrimaryKey(service);
        return service.getContent();
    }

    /*
     * type=2是用户，type=1是管理员
     * status=0是双方已读，status=2是管理员未读，status=1是用户未读
     * */
    @Override
    public void addHelpText(int id, String content, short type, String username) {
        com.suxton.kunmall.pojo.Service service = serviceMapper.selectByPrimaryKey(id);
        if (service == null) {
            service = new com.suxton.kunmall.pojo.Service();
            service.setUserid(id);
            service.setContent(content);
            service.setUsername(username);
            service.setStatus(type);
            service.setLastchat(new Date());
            serviceMapper.insert(service);
        } else {
            service.setContent(service.getContent() + "\n" + content);
            service.setStatus(type);
//            logger.warn(service.getStatus() + "");
            service.setLastchat(new Date());
            serviceMapper.updateByPrimaryKey(service);
        }
    }

    @Override
    public List<com.suxton.kunmall.pojo.Service> getServiceList() {
        ServiceExample serviceExample = new ServiceExample();
        serviceExample.setOrderByClause("status DESC");
        return serviceMapper.selectByExample(serviceExample);
    }

    @Override
    public boolean isUnread(int id) {
        com.suxton.kunmall.pojo.Service service = serviceMapper.selectByPrimaryKey(id);
        return service.getStatus() == 1;
    }
}
