package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.User;

public interface UserService {
    void createUser(String name, String password);

    boolean verifyUser(String name, String password);

    boolean hasUser(String name);
    User getUserByName(String name);
}
