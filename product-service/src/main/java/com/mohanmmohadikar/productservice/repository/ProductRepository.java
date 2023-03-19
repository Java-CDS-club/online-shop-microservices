package com.mohanmmohadikar.productservice.repository;

import com.mohanmmohadikar.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
