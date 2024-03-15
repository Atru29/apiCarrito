package com.ecommerce.product.service.impl;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductServiceImpl implements ProductService {
    private static final AtomicInteger counter = new AtomicInteger();
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product createProduct(Product product) {
        product.setId(counter.incrementAndGet());
        products.add(product);
        return product;
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getProductById(Integer id) {
        return products.stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }
}
