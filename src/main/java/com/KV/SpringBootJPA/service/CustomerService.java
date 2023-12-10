package com.KV.SpringBootJPA.service;

import com.KV.SpringBootJPA.entity.CustomersEntity;

import java.util.List;

public interface CustomerService {
    List<CustomersEntity> findAllCustomers();
    CustomersEntity createCustomer(CustomersEntity customer);
    CustomersEntity findCustomerById(int id);
}
