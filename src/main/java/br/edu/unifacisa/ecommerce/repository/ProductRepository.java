package br.edu.unifacisa.ecommerce.repository;

import br.edu.unifacisa.ecommerce.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }
    public Product createProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product findById(String id) {
        for (Product product: products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findAllProducts() {
        return products;
    }
}
