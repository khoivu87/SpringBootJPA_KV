package com.KV.SpringBootJPA.controller;

import com.KV.SpringBootJPA.entity.OrdersEntity;
import com.KV.SpringBootJPA.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrdersRepository ordersRepository;

     @GetMapping("")
     public ResponseEntity<?> getOrder() {
         List<OrdersEntity> listOrders = ordersRepository.findAll();
         return new ResponseEntity<>(listOrders, HttpStatus.OK);
     }


}
