package com.accesadades.botiga.Controller;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Service.CategoryService;
import com.accesadades.botiga.Service.SubcategoryService;
import com.accesadades.botiga.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping("/")
    public String home() {
        return "index"; 
    }

    @GetMapping("/productes/nou")
    public String mostrarFormulariCreacio(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
        
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categories);
        model.addAttribute("subcategories", subcategories);
        return "creacio-producte"; 
    }

    @PostMapping("/productos/desar")
public String saveProduct(@RequestParam("nom") String nom,
                          @RequestParam("descripcio") String descripcio,
                          @RequestParam("unitats") int unitats,
                          @RequestParam("preu") float preu,
                          @RequestParam("fabricant") String fabricant,
                          @RequestParam("subcategoria") Long subcategoryId,
                          @RequestParam("categoria") Long categoryId,
                          Model model) {
    Subcategory subcategory = subcategoryService.findSubcategoryById(subcategoryId);
    Category category = categoryService.findCategoryById(categoryId);

    if (subcategory == null || category == null) {
        model.addAttribute("error", "Categoria o subcategoria no vàlida.");
        return "crearProducto";
    }

    Product product = new Product();
    product.setName(nom);
    product.setDescription(descripcio);
    product.setUnits(unitats);
    product.setCompany(fabricant);
    product.setSubcategory(subcategory);

    productService.saveProduct(product);

    return "redirect:/catalogo";
}


    @GetMapping("/catalog")
    public String mostrarCatalogo(Model model) {
        List<Product> productes = productService.getAllProducts();
        model.addAttribute("productes", productes);
        return "catalog"; 
    }

    @GetMapping("/productos/crear")
    public String showCreateProductForm(Model model) {
    Set<Category> categories = categoryService.findAllCategories();
    Set<Subcategory> subcategories = subcategoryService.findAllSubcategories();
    model.addAttribute("product", new Product());
    model.addAttribute("categories", categories);
    model.addAttribute("subcategories", subcategories);
    return "crearProducto";
}

}
