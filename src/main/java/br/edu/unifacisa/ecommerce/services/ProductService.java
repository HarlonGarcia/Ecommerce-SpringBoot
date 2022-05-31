package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.entities.Category;
import br.edu.unifacisa.ecommerce.entities.Product;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    public Product createProduct(Product product) {
        Category category = categoryService.findCategoryById(product.getCategory_id());
        category.getProducts().add(product);
        return productRepository.createProduct(product);
    }

    public Product editProduct(Product product) throws ContentNotFoundException {
        Product productUpdated = productRepository.findById(product.getId());
        if (productUpdated != null) {
            productUpdated.setName(product.getName());
            productUpdated.setPrice(product.getPrice());
            productUpdated.setDescription(product.getDescription());
            return productUpdated;
        }
        throw new ContentNotFoundException("Product not found.");
    }

    public Product findById(String id) throws ContentNotFoundException {
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
