package br.edu.unifacisa.ecommerce.entities;
import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = -8588157270452675140L;
    private int id;
    private String name;
    private String description;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
