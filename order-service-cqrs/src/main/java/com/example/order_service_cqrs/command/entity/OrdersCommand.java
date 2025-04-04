package com.example.order_service_cqrs.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Orders_Command")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private Integer quantity;
    private Double price;
}
