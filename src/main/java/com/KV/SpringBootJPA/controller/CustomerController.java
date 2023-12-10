package com.KV.SpringBootJPA.controller;

import com.KV.SpringBootJPA.entity.CustomersEntity;
import com.KV.SpringBootJPA.repository.CustomersRepository;
import com.KV.SpringBootJPA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<?> getCustomer() {
        List<CustomersEntity> listCustomers = customerService.findAllCustomers();
        return new ResponseEntity<>(listCustomers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomersEntity> createCustomer(@Validated @RequestBody CustomersEntity customer) {
        try {
            CustomersEntity customersEntity = customerService.createCustomer(customer);
            return new ResponseEntity<>(customersEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") int id) {
        CustomersEntity customersEntity = customerService.findCustomerById(id);
        if (customersEntity == null) {
            return new ResponseEntity<>("Không tìm thấy customer", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customersEntity, HttpStatus.OK);
    }
}