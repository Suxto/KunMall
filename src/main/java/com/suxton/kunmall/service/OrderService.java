package com.suxton.kunmall.service;

import com.suxton.kunmall.pojo.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getUnfinishedOrders();

    List<Orders> getAllOrders();
}
