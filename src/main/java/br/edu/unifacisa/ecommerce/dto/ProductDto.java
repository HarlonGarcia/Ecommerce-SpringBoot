package br.edu.unifacisa.ecommerce.dto;

public class ProductDto {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private String percentage;

    public ProductDto(String id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void calculatePercentage(double amount) {
        int result = (int) Math.round(price * 100 / amount);
        this.percentage = result + "%";
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPercentage() {
        return percentage;
    }
}
