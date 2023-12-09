package com.KV.SpringBootJPA.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "customers")
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<OrdersEntity> orders;

    public CustomersEntity() {
    }

    public CustomersEntity(Set<OrdersEntity> orders) {
        this.orders = orders;
    }

    public CustomersEntity(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




