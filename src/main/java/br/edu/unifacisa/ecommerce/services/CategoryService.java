package br.edu.unifacisa.ecommerce.services;
import br.edu.unifacisa.ecommerce.entities.Category;
import br.edu.unifacisa.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.addNewCategory(category);
    }

    public void deleteCategory(int id) {
        Category categoryToDelete = categoryRepository.findCategoryById(id);
        categoryRepository.deleteCategory(categoryToDelete);
    }

    public Category editCategory(Category category) {
        Category categoryUpdated = categoryRepository.findCategoryById(category.getId());
        categoryUpdated.setName(category.getName());
        categoryUpdated.setDescription(category.getDescription());
        return categoryUpdated;
    }

    public Category findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }
}
