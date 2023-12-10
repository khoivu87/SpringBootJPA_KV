package com.KV.SpringBootJPA.service;

import com.KV.SpringBootJPA.entity.OrdersEntity;
import com.KV.SpringBootJPA.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<OrdersEntity> findAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public OrdersEntity createOrder(OrdersEntity order) {
        return ordersRepository.save(order);
    }

    @Override
    public OrdersEntity findOrderById(int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrdersEntity> findOrdersByCustomerId(int customerId) {
        return ordersRepository.findByCustomerId(customerId);
    }
}
