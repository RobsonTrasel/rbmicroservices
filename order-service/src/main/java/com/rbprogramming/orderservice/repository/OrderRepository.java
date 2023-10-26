package com.rbprogramming.orderservice.repository;

import com.rbprogramming.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
