package com.accesadades.botiga.Service;

import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory getSubcategoryById(Long id) {
        return subcategoryRepository.findById(id).orElse(null);
    }

    @Override
    public Subcategory saveSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }

    @Override
    public Subcategory findSubcategoryByName(String name) {
        return subcategoryRepository.findByName(name);
    }
}
