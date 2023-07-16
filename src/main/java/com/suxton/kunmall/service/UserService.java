package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.pojo.User;
import com.suxton.kunmall.pojo.UserConsumed;

import java.util.List;

public interface UserService {
    void createUser(String name, String password);

    boolean verifyUser(String name, String password);

    boolean hasUser(String name);
    User getUserByName(String name);

    void createOrder(Orders order);

    List<Orders> getUserOrderList(int id);

    List<UserConsumed> getUserConsumed();

    List<User> getAllUsers();

    void changeRole(int id);

    void updatePassword(int id, String password);

    void getHelpText(int id);
}
