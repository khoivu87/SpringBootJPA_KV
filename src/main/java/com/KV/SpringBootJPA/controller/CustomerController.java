package com.KV.SpringBootJPA.controller;

import com.KV.SpringBootJPA.entity.CustomersEntity;
import com.KV.SpringBootJPA.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomersRepository customersRepository;

    @GetMapping("")
    public ResponseEntity<?> getCustomer() {
        List<CustomersEntity> listCustomers = customersRepository.findAll();
        return new ResponseEntity<>(listCustomers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomersEntity> createCustomer(@Validated @RequestBody CustomersEntity customer) {
        try {
            CustomersEntity customersEntity = customersRepository.save(customer);
            return new ResponseEntity<>(customersEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") int id) {
        CustomersEntity customersEntity = customersRepository.findById(id);
        return new ResponseEntity<>(customersEntity, HttpStatus.OK);
    }
}
