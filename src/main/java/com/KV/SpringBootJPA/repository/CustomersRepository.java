package com.KV.SpringBootJPA.repository;

import com.KV.SpringBootJPA.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer> {
}
