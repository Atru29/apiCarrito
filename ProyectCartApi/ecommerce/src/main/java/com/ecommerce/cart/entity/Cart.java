package com.ecommerce.cart.entity;

import com.ecommerce.product.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Integer id;
    private List<Product> products;

    public Cart(Integer id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void agregarProducto(Product producto) {
        this.products.add(producto);
    }
}
