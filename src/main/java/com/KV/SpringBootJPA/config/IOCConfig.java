package com.KV.SpringBootJPA.config;

import com.KV.SpringBootJPA.entity.OrdersEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IOCConfig {
    @Bean
    public OrdersEntity createOrderIOC() {
        OrdersEntity order = new OrdersEntity();
        order.setId(1);
        order.setCustomerId(1);
        order.setTotalAmount(100.0);
        order.setOrderCode("ORD-001");

        return order;
    }
}
