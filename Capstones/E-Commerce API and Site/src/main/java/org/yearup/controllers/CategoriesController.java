package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

@RestController
// http://localhost:8080/categories
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {

    private CategoryDao categoryDao;
    private ProductDao productDao;


    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {

        return new ResponseEntity<>(categoryDao.getAllCategories(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        return new ResponseEntity<>(categoryDao.getById(id), HttpStatus.OK);
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable int categoryId) {
        return new ResponseEntity<>(productDao.listByCategoryId(categoryId), HttpStatus.OK);
    }


    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        // insert the category
        return new ResponseEntity<>(categoryDao.create(category), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category>  updateCategory(@PathVariable int id, @RequestBody Category category) {

        return new ResponseEntity<>(categoryDao.update(id, category), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
