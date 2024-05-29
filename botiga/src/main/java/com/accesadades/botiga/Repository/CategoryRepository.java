package com.accesadades.botiga.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.accesadades.botiga.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
    Category findByName(String name);
    default Category findCategoryByName(String name) { // Cambiado 'Nom' a 'Name'
    return findByName(name);
    }
}
