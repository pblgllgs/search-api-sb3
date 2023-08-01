package com.pblgllgs.searchapi.controller;

import com.pblgllgs.searchapi.entity.Product;
import com.pblgllgs.searchapi.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/search")
    public ResponseEntity<Optional<List<Product>>> searchProducts(@RequestParam String query){
        return new ResponseEntity<>(productRepository.searchProductsBy(query),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productRepository.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productRepository.save(product),HttpStatus.CREATED);
    }
}
