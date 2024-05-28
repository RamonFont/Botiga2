package com.accesadades.botiga.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.accesadades.botiga.Model.Subcategory;

import java.util.Set;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {
    Set<Subcategory> findAll();
    Subcategory findByNom(String nom);
}
