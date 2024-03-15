package com.ecommerce.cart.service.impl;

import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.service.CartService;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartServiceImpl implements CartService {
    private final Map<Integer, Cart> carts = new HashMap<>();
    private final ProductService productService;
    private final AtomicInteger counterId = new AtomicInteger();

    @Autowired
    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public Cart createCart() {
        int id = counterId.incrementAndGet();
        Cart cart = new Cart(id);
        carts.put(id, cart);
        return cart;
    }
    @Override
    public void addProductToCartById(Integer cartId, Integer productId) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            Product product = productService.getProductById(productId);
            if (product != null) {
                cart.agregarProducto(product);
            } else {
                throw new IllegalArgumentException("Producto no encontrado");
            }
        } else {
            throw new IllegalArgumentException("Carrito no encontrado");
        }
    }
    @Override
    public Cart getCartById(Integer cartId) {
        return carts.get(cartId);
    }
}
