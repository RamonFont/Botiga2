package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
    Category findCategoryByName(String name);
}
