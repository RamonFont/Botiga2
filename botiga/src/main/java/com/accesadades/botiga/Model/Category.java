package com.accesadades.botiga.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Subcategory> subcategories;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    

}
