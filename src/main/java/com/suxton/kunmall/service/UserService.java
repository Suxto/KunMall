package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.pojo.User;

import java.util.List;

public interface UserService {
    void createUser(String name, String password);

    boolean verifyUser(String name, String password);

    boolean hasUser(String name);
    User getUserByName(String name);

    void createOrder(Orders order);

    List<Orders> getUserOrderList(int id);
}
