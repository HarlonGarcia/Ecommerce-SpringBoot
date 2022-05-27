package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.entities.Product;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    public Product editProduct(Product product) {
        return null;
    }

    public Product findById(int id) throws ContentNotFoundException {
        Product product = productRepository.findById(id);
        if (product != null) {
            return product;
        }
        throw new ContentNotFoundException("Product not found.");
    }

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
