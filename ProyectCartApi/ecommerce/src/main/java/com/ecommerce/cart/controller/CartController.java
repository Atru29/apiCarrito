package com.ecommerce.cart.controller;


import com.ecommerce.cart.entity.Cart;
import com.ecommerce.cart.service.CartService;
import com.ecommerce.cart.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartServiceImpl carritoService) {
        this.cartService = carritoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @PostMapping("/{cartId}/add/{productId}")
    public ResponseEntity<?> addProductToCartById(@PathVariable Integer cartId, @PathVariable Integer productId) {
        try {
            cartService.addProductToCartById(cartId, productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Integer cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

