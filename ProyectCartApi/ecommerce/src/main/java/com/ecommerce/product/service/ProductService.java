package com.ecommerce.product.service;

import com.ecommerce.product.entity.Product;

import java.util.List;

public interface ProductService {

    public Product createProduct(Product product);
   public List<Product> listAllProducts();
   public Product getProductById(Integer id);
}
