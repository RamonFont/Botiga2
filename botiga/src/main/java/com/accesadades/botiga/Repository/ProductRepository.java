package com.accesadades.botiga.Repository;

import com.accesadades.botiga.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
