package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.model.Cart;
import com.example.ecommerce_api.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}")
    public ResponseEntity<Cart> createCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.createCart(userId));
    }

    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return ResponseEntity.ok(cartService.addProductToCart(cartId, productId));
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.getCart(cartId));
    }
}