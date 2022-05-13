package br.edu.unifacisa.ecommerce.controllers;

import br.edu.unifacisa.ecommerce.entities.Product;
import br.edu.unifacisa.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.editProduct(product), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<List<Product>>(productService.findAllProducts(), HttpStatus.OK);
    }
}
