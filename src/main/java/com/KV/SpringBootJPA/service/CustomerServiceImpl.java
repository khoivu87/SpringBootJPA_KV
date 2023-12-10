package com.KV.SpringBootJPA.service;

import com.KV.SpringBootJPA.entity.CustomersEntity;
import com.KV.SpringBootJPA.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public List<CustomersEntity> findAllCustomers() {
        return (List<CustomersEntity>)customersRepository.findAll();
    }

    @Override
    public CustomersEntity createCustomer(CustomersEntity customer) {
        return customersRepository.save(customer);
    }

    @Override
    public CustomersEntity findCustomerById(int id) {
        return customersRepository.findById(id).orElse(null);
    }
}
