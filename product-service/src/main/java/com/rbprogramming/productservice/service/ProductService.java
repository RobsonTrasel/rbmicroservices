package com.rbprogramming.productservice.service;

import com.rbprogramming.productservice.dto.ProductRequest;
import com.rbprogramming.productservice.model.Product;
import com.rbprogramming.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("[PRODUCT] Product {} is saved", product.getId());
    }
}
