package com.accesadades.botiga.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.accesadades.botiga.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Product findByName(String name);
}
