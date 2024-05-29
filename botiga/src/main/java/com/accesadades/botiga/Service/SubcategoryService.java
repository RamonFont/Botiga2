package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Subcategory;
import java.util.List;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();
    Subcategory getSubcategoryById(Long id);
    Subcategory saveSubcategory(Subcategory subcategory);
    void deleteSubcategory(Long id);
    Subcategory findSubcategoryByName(String name);
}
