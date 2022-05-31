package br.edu.unifacisa.ecommerce.repository;

import br.edu.unifacisa.ecommerce.entities.Category;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private List<Category> categories;

    public CategoryRepository() {
        this.categories = new ArrayList<>();
    }
    public Category addNewCategory(Category category) {
        categories.add(category);
        return category;
    }
    public void deleteCategory(Category category) {
        categories.remove(category);
    }

    public Category findCategoryById(int id) {
        for (Category category: categories) {
            if (category.getId() == (id)) return category;
        }
        return null;
    }
    public List<Category> findAll() {
        return categories;
    }
}
