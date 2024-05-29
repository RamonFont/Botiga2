package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.SubcategoryRepository;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Set<Subcategory> findAllSubcategories() {
        return new HashSet<>(subcategoryRepository.findAll());
    }

    @Override
    public Subcategory findSubcategoryByNom(String nom) {
        return subcategoryRepository.findByNom(nom);
    }

    @Override
    public Subcategory findSubcategoryById(Long id) {
        return subcategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSubcategory(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubcategoryById(Long id) {
        subcategoryRepository.deleteById(id);
    }

    @Override
    public List<Subcategory> getAllSubcategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSubcategories'");
    }
}
