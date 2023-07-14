package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.User;

public interface UserService {
    void createUser(User user);
    boolean verifyUser(User user);
}
