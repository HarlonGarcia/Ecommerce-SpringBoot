package br.edu.unifacisa.ecommerce.entities;
import br.edu.unifacisa.ecommerce.dto.ProductDto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Product implements Serializable {
    private static final long serialVersionUID = -1386366526672841108L;
    private String id;
    private String name;
    private double price;
    private String description;
    private int category_id;

    public Product() {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,8);
    }

    public Product(String name, double price, String description, int category_id) {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,8);
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductDto toDto() {
        return new ProductDto(getId(), getName(), getPrice(), getDescription());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) && getCategory_id() == product.getCategory_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory_id());
    }
}
