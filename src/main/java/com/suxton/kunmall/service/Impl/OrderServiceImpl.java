package com.suxton.kunmall.service.Impl;

import com.suxton.kunmall.dao.OrdersMapper;
import com.suxton.kunmall.pojo.Orders;
import com.suxton.kunmall.pojo.OrdersExample;
import com.suxton.kunmall.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> getUnfinishedOrders() {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.or().andStatusNotEqualTo("已完成");
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersMapper.selectByExample(new OrdersExample());
    }
}
