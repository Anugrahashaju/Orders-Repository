package com.example.order_service_cqrs.command.repository;

import com.example.order_service_cqrs.command.entity.OrdersCommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCommandRepository extends JpaRepository<OrdersCommand,Long> {

}
