package org.example.service;

import org.example.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product p);
    Product update(Product p);
    Optional<Product> findIfProductIsInStock(String id, int quantity);

    Optional<Product> findById(String id);

    void deleteById(String pid);
}
