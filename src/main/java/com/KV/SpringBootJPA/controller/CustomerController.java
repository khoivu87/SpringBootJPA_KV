package com.KV.SpringBootJPA.controller;

import com.KV.SpringBootJPA.entity.CustomersEntity;
import com.KV.SpringBootJPA.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping("")
    public ResponseEntity<?> getOrder() {
        List<CustomersEntity> listCustomers = customersRepository.findAll();
        return new ResponseEntity<>(listCustomers, HttpStatus.OK);
    }


}
