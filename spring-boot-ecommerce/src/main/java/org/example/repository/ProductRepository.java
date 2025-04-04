package org.example.repository;

import org.example.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByProductIdAndStockGreaterThan(String id, int stock);

    //Optional<Product> findProductInStock(String id, int quantity);
}
