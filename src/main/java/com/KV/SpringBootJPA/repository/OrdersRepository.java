package com.KV.SpringBootJPA.repository;

import com.KV.SpringBootJPA.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
    List<OrdersEntity> findByCustomerId(int customerId);
}
