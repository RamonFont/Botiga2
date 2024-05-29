package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Service.CategoryService;
import com.accesadades.botiga.Service.SubcategoryService;
import com.accesadades.botiga.Service.ProductService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        if (categoryService.getAllCategories().isEmpty()) {
            Category category = new Category();
            category.setName("Fruits");
            categoryService.saveCategory(category);

            Subcategory subcategory = new Subcategory();
            subcategory.setName("Citrics");
            subcategory.setCategory(category);
            subcategoryService.saveSubcategory(subcategory);

            Product product = new Product();
            product.setName("Lemon");
            product.setDescription("Fresh and juicy");
            product.setCompany("Supplier A");
            product.setPrice(1.5f);
            product.setUnits(100);
            product.setSubcategory(subcategory);
            productService.saveProduct(product);
        }
    }
}
