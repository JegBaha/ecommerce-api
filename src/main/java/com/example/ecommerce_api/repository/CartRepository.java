package com.example.ecommerce_api.repository;

import com.example.ecommerce_api.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}