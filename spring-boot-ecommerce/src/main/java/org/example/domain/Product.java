package org.example.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_details")

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Product {

  @Id // Every entity class must have an @Id attribute
  @GeneratedValue(strategy = GenerationType.UUID) // Automatically generate the UUID value for this field
  @Column(name = "p_id") // Name of the column in the table
  private String productId;

  @Column(name = "p_name", nullable = false)// Cannot have null values
  private String productName;

  @Column(nullable = false)
  private double price;

  @Column(nullable = false)
  private int stock;
}
