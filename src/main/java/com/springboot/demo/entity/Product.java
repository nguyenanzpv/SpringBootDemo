package com.springboot.demo.entity;

import com.springboot.demo.enumeration.EntityStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long product_id;
    private String product_code;
    private String product_name;
    private String manufacture;
    private String small_unit;
    private int quantity_by_small_unit;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EntityStatus status;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getSmall_unit() {
        return small_unit;
    }

    public void setSmall_unit(String small_unit) {
        this.small_unit = small_unit;
    }

    public int getQuantity_by_small_unit() {
        return quantity_by_small_unit;
    }

    public void setQuantity_by_small_unit(int quantity_by_small_unit) {
        this.quantity_by_small_unit = quantity_by_small_unit;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Collection<Category> categories;

    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
}
