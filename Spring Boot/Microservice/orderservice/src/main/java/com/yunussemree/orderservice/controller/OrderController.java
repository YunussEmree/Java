package com.yunussemree.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public List<Map<String, Object>> getOrders() {
        return List.of(
                Map.of("id", 101, "item", "Book"),
                Map.of("id", 102, "item", "Pen")
        );
    }
}
