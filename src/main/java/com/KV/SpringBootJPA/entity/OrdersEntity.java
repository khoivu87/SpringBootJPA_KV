package com.KV.SpringBootJPA.entity;

import jakarta.persistence.*;

@Entity(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "customer_id")
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomersEntity customer;

    public OrdersEntity() {
    }

    public OrdersEntity(String orderCode, Double totalAmount, int customerId) {
        this.orderCode = orderCode;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    public OrdersEntity(int id, String orderCode, Double totalAmount, int customerId) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalAmount = totalAmount;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
