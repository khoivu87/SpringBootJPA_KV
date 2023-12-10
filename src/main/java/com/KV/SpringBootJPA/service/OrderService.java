package com.KV.SpringBootJPA.service;

import com.KV.SpringBootJPA.entity.OrdersEntity;

import java.util.List;

public interface OrderService {
    List<OrdersEntity> findAllOrders();
    OrdersEntity createOrder(OrdersEntity order);
    OrdersEntity findOrderById(int id);

    List<OrdersEntity> findOrdersByCustomerId(int id);
}
