package com.rbprogramming.orderservice.controller;

import com.rbprogramming.orderservice.dto.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class OrderController {
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return "Order placed successfully";
    }
}
