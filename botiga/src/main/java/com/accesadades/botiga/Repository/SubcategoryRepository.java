package com.accesadades.botiga.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findAll();
    Subcategory findByName(String name);
}
