package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getUnfinishedOrders();

    List<Orders> getAllOrders();

    List<Orders> getOrderByUserID(int id);

    void updateStatusByID(int id, String status);
}
