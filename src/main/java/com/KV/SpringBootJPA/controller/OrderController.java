package com.KV.SpringBootJPA.controller;

import com.KV.SpringBootJPA.entity.OrdersEntity;
import com.KV.SpringBootJPA.repository.CustomersRepository;
import com.KV.SpringBootJPA.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping("")
     public ResponseEntity<?> getOrder() {
         List<OrdersEntity> listOrders = orderService.findAllOrders();
         return new ResponseEntity<>(listOrders, HttpStatus.OK);
     }

    @PostMapping("/create")
    public ResponseEntity<OrdersEntity> createOrder(@Validated @RequestBody OrdersEntity order) {
        try {
            OrdersEntity ordersEntity = orderService.createOrder(order);
            return new ResponseEntity<>(ordersEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") int id) {
        OrdersEntity ordersEntity = orderService.findOrderById(id);
        if (ordersEntity == null) {
            return new ResponseEntity<>("Không tìm thấy order", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersEntity, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getOrderByCustomerId(@PathVariable("id") int customerId) {
        List<OrdersEntity> ordersEntity = orderService.findOrdersByCustomerId(customerId);
        if (ordersEntity == null) {
            return new ResponseEntity<>("Không tìm thấy order", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersEntity, HttpStatus.OK);
    }
}
