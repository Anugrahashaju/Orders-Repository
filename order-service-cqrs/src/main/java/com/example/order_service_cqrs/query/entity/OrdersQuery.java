package com.example.order_service_cqrs.query.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Orders_query")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrdersQuery{

    @Id
    private Long id;
    private String product;
    private Integer quantity;
    private Double price;
}
