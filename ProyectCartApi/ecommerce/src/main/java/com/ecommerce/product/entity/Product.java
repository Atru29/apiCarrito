package com.ecommerce.product.entity;

public class Product {
    private Integer id;
    private String description;
    private Double amount;

    public Product(String description,Double amount){
        this.description= description;
        this.amount= amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
