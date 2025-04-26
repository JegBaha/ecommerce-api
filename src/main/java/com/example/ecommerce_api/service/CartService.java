package com.example.ecommerce_api.service;

import com.example.ecommerce_api.model.Cart;
import com.example.ecommerce_api.model.Product;
import com.example.ecommerce_api.model.User;
import com.example.ecommerce_api.repository.CartRepository;
import com.example.ecommerce_api.repository.ProductRepository;
import com.example.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public Cart createCart(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        Cart cart = new Cart();
        cart.setUser(user.get());
        return cartRepository.save(cart);
    }

    public Cart addProductToCart(Long cartId, Long productId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Product> product = productRepository.findById(productId);
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart not found");
        }
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        Cart updatedCart = cart.get();
        updatedCart.getProducts().add(product.get());
        return cartRepository.save(updatedCart);
    }

    public Cart getCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart not found");
        }
        return cart.get();
    }
}