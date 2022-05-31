package br.edu.unifacisa.ecommerce.entities;

import br.edu.unifacisa.ecommerce.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ProductDto> products = new ArrayList<>();
    private double amount;
    public Cart() {
    }

    public void addProduct(ProductDto product) {
        products.add(product);
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public double getAmount() {
        return amount;
    }

    public void addToTotalAmount(double amount) {
        this.amount += amount;
    }
}
