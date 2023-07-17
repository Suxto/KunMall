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


    String getHelpText(int id, short type);

    /*
     * type=1是用户，type=2是管理员
     * status=0是双方已读，status=1是管理员未读，status=2是用户未读
     * */
    void addHelpText(int id, String content, short type, String username);

    List<com.suxton.kunmall.pojo.Service> getServiceList();
}
