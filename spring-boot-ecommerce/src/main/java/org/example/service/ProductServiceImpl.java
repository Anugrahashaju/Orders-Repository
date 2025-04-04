package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product update(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Optional<Product> findIfProductIsInStock(String id, int quantity) {
        return productRepository.findByProductIdAndStockGreaterThan(id,quantity);
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(String pid) {
        productRepository.deleteById(pid);
    }

}
