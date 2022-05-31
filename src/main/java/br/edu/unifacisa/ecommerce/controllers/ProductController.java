package br.edu.unifacisa.ecommerce.controllers;

import br.edu.unifacisa.ecommerce.entities.Product;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> editProduct(@RequestBody Product product) {
        try {
            productService.editProduct(product);
            return new ResponseEntity<String>("Product updated successfully!", HttpStatus.OK);
        } catch (ContentNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<List<Product>>(productService.findAllProducts(), HttpStatus.OK);
    }
}
