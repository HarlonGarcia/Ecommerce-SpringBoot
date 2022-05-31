package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.dto.ProductDto;
import br.edu.unifacisa.ecommerce.entities.Cart;
import br.edu.unifacisa.ecommerce.entities.Category;
import br.edu.unifacisa.ecommerce.entities.Product;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    public boolean addProductToCart(String productId, String username) throws ContentNotFoundException {
        Product product = productService.findById(productId);
        if (product != null) {
            Cart cart = findCartByUsername(username);
            if (cart != null) {
                cart.addToTotalAmount(product.getPrice());
                ProductDto productDto = product.toDto();
                productDto.setCategory(findCategoryName(product.getCategory_id()));
                cart.addProduct(productDto);
                return true;
            }
            throw new ContentNotFoundException("User not found.");
        }
        throw new ContentNotFoundException("Product not found.");
    }

    public Cart findCartByUsername(String username) throws ContentNotFoundException {
        User user = userService.findByUsername(username);
        if (user != null) {
            Cart cart = user.getCart();
            for (ProductDto productDto : cart.getProducts()) {
                productDto.calculatePercentage(cart.getAmount());
            }
            return cart;
        }
        throw new ContentNotFoundException("User not found.");
    }

    public String findCategoryName(int id) throws ContentNotFoundException {
        List<Category> categories = categoryService.findAll();
        for (Category category: categories) {
            if (category.getId() == id) return category.getName();
        }
        throw new ContentNotFoundException("Category not found.");
    }
}
