package com.springboot.demo.entity;

import com.springboot.demo.enumeration.EntityStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long category_id;
    private String category_name;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EntityStatus status;

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }


    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    @ManyToMany(mappedBy = "categories")
    private Collection<Product> products;
}
