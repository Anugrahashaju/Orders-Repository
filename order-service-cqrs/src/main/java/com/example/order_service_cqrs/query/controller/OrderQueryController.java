package com.example.order_service_cqrs.query.controller;

import com.example.order_service_cqrs.command.entity.OrdersCommand;
import com.example.order_service_cqrs.command.service.OrderCommandService;
import com.example.order_service_cqrs.query.entity.OrdersQuery;
import com.example.order_service_cqrs.query.repository.OrderQueryRepository;
import com.example.order_service_cqrs.query.service.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/orders")
@RequiredArgsConstructor
public class OrderQueryController {

    private final OrderQueryRepository orderQueryRepository;

    @GetMapping
    /*public ResponseEntity<List<OrdersQuery>> getAllOrders() {
        var response = orderQueryRepository.findAll();
        System.err.println(response);
        return ResponseEntity.ok(response);
    }*/
    public List<OrdersQuery> getAllOrders()
    {
        return orderQueryRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrdersQuery getOrderById(@PathVariable Long id) {
        return orderQueryRepository.findById(id).orElseThrow();
    }
}
