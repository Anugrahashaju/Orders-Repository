package com.example.order_service_cqrs.command.controller;

import com.example.order_service_cqrs.command.entity.OrdersCommand;
import com.example.order_service_cqrs.command.service.OrderCommandService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/command/orders")
@RequiredArgsConstructor

public class OrderCommandController {
    private final OrderCommandService orderCommandService;

    @PostMapping
    public OrdersCommand createOrder(@RequestBody OrdersCommand ordersCommand)
    {
        return orderCommandService.createOrder(ordersCommand);
    }
}
