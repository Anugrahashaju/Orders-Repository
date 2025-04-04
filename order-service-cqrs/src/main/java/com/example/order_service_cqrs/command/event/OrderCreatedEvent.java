package com.example.order_service_cqrs.command.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class OrderCreatedEvent {
    private Long orderId;
    private String product;
    private Integer quantity;
    private Double price;
}
