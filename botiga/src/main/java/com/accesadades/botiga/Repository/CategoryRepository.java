package com.accesadades.botiga.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.accesadades.botiga.Model.Category;

import java.util.Set;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Set<Category> findAll();
    Category findByNom(String nom);
}
