package br.edu.unifacisa.ecommerce.controllers;
import br.edu.unifacisa.ecommerce.entities.Category;
import br.edu.unifacisa.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Category> editCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.editCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("id") int id) {
        return new ResponseEntity<Category>(categoryService.findCategoryById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        return new ResponseEntity<List<Category>>(categoryService.findAllCategories(), HttpStatus.OK);
    }
}
