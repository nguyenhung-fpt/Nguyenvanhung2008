package com.example.t2009a_nguyenvanhung_abcshop.controller;

import com.example.t2009a_nguyenvanhung_abcshop.model.Product;
import com.example.t2009a_nguyenvanhung_abcshop.services.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IproductService productService;

    // Add
    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    // Get
    @GetMapping
    public ResponseEntity<Iterable<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    // Get 1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Product> sellProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> categoryOptional = productService.findById(id);
        return categoryOptional.map(product1 -> {
            product.setId(product1.getId());
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete A
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> categoryOptional = productService.findById(id);
        return categoryOptional.map(category -> {
            productService.remove(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

