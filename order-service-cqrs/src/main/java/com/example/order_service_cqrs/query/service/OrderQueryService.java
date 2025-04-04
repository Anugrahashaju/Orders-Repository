package com.example.order_service_cqrs.query.service;


import com.example.order_service_cqrs.command.event.OrderCreatedEvent;
import com.example.order_service_cqrs.command.repository.OrderCommandRepository;
import com.example.order_service_cqrs.query.entity.OrdersQuery;
import com.example.order_service_cqrs.query.repository.OrderQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderQueryService {

    private final OrderQueryRepository orderQueryRepository;

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event)
    {
        OrdersQuery ordersQuery = new OrdersQuery(
                event.getOrderId(),
                event.getProduct(),
                event.getQuantity(),
                event.getPrice()
        );
        orderQueryRepository.save(ordersQuery);
    }
}
