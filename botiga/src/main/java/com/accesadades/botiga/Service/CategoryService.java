package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Set;
import com.accesadades.botiga.Model.Category;

public interface CategoryService {
    Set<Category> findAllCategories();
    Category findCategoryByNom(String nom);
    Category findCategoryById(Long id);
    void saveCategory(Category category);
    void deleteCategoryById(Long id);
    List<Category> getAllCategories();
}
