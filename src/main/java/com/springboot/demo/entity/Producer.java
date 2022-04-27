package com.springboot.demo.entity;

import com.springboot.demo.enumeration.EntityStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Entity
class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long producer_id;
    private String name;
    private String address;
    private String phone;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EntityStatus status;

    public long getProducer_id() {
        return producer_id;
    }

    public void setProducer_id(long producer_id) {
        this.producer_id = producer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @OneToMany(mappedBy = "producer")
    private Collection<Product> products;
}
