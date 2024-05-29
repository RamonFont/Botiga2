package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public Set<Category> findAllCategories() {
        return new HashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }

    @Override
    public Category findCategoryByNom(String nom) {
        throw new UnsupportedOperationException("Unimplemented method 'findCategoryByNom'");
    }
}
