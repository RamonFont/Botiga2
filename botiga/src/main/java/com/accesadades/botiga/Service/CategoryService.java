package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Category;

public interface CategoryService {
    Set<Category> findAllCategories();
    Category findCategoryByNom(String nom);
    void saveCategory(Category category);
    void deleteCategoryById(Long id);
}

