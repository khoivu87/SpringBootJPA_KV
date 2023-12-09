package com.KV.SpringBootJPA.controller;

import com.KV.SpringBootJPA.entity.OrdersEntity;
import com.KV.SpringBootJPA.repository.CustomersRepository;
import com.KV.SpringBootJPA.repository.OrdersRepository;
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
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping("")
     public ResponseEntity<?> getOrder() {
         List<OrdersEntity> listOrders = ordersRepository.findAll();
         return new ResponseEntity<>(listOrders, HttpStatus.OK);
     }

    @PostMapping("/create")
    public ResponseEntity<OrdersEntity> createOrder(@Validated @RequestBody OrdersEntity order) {
        try {
            OrdersEntity ordersEntity = ordersRepository.save(order);
            return new ResponseEntity<>(ordersEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getOrderByCustomerId(@PathVariable("id") int id) {
        List<OrdersEntity> ordersEntity = ordersRepository.findAllByCustomerId(id);
        if (customersRepository.findById(id) == null) {
            return new ResponseEntity<>("Không tìm thấy order", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ordersEntity, HttpStatus.OK);
    }
}
