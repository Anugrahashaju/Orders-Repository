package com.example.order_service_cqrs.command.service;

import com.example.order_service_cqrs.command.entity.OrdersCommand;
import com.example.order_service_cqrs.command.event.OrderCreatedEvent;
import com.example.order_service_cqrs.command.repository.OrderCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommandService {

    private final OrderCommandRepository orderCommandRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrdersCommand createOrder(OrdersCommand order)
    {
        OrdersCommand savedOrder = orderCommandRepository.save(order);
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getProduct(),
                savedOrder.getQuantity(),
                savedOrder.getPrice()
        ));
        return  savedOrder;
    }
}
