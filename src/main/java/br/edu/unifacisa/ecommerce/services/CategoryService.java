package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.entities.Category;
import br.edu.unifacisa.ecommerce.entities.Product;
import br.edu.unifacisa.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        Random random = new Random();
        int numeroMenor = random.nextInt(100000);
        category.setId(numeroMenor);
        return categoryRepository.addNewCategory(category);
    }

    public void deleteCategory(int id) {
        Category categoryToDelete = categoryRepository.findCategoryById(id);
        categoryRepository.deleteCategory(categoryToDelete);
    }

    public Category editCategory(Category category) {
        Category categoryUpdated = categoryRepository.findCategoryById(category.getId());
        categoryUpdated.setName(category.getName());
        return categoryUpdated;
    }

    public Category findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
