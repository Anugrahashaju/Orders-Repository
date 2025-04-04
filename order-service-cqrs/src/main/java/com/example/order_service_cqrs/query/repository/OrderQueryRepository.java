package com.example.order_service_cqrs.query.repository;

import com.example.order_service_cqrs.command.entity.OrdersCommand;
import com.example.order_service_cqrs.query.entity.OrdersQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderQueryRepository extends JpaRepository<OrdersQuery,Long> {

}
