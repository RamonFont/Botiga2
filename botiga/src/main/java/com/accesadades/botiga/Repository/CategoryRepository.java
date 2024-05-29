package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
