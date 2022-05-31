package br.edu.unifacisa.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
    private static final long serialVersionUID = -8588157270452675140L;
    private int id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
