package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Subcategory;

public interface SubcategoryService {
    Set<Subcategory> findAllSubcategories();
    Subcategory findSubcategoryByNom(String nom);
    Subcategory findSubcategoryById(Long id); 
    void saveSubcategory(Subcategory subcategory);
    void deleteSubcategoryById(Long id);
}
