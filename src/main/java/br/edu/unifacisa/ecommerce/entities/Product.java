package br.edu.unifacisa.ecommerce.entities;
import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -1386366526672841108L;
    private String name;
    private double price;
    private String description;
    private int categoryId;

    public Product() {
    }

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
