package com.ecommerce.cart.service;

import com.ecommerce.cart.entity.Cart;

public interface CartService {
    public Cart createCart();
    public void addProductToCartById(Integer cartId, Integer productId);
    public Cart getCartById(Integer cartId);
}
