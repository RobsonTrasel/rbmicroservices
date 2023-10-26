package com.rbprogramming.productservice.repository;

import com.rbprogramming.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {


}
