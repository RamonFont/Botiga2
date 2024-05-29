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
        Subcategory subcategory = subcategoryService.getSubcategoryById(subcategoryId);
        Category category = categoryService.getCategoryById(categoryId);

        if (subcategory == null || category == null) {
            model.addAttribute("error", "Categoria o subcategoria no vàlida.");
            return "crearProducto";
        }

        Product product = new Product();
        product.setName(nom);
        product.setDescription(descripcio);
        product.setUnits(unitats);
        product.setPrice(preu);
        product.setCompany(fabricant);
        product.setSubcategory(subcategory);

        productService.saveProduct(product);

        return "redirect:/catalog";
    }

    @GetMapping("/catalog")
    public String mostrarCatalogo(Model model) {
        List<Product> productes = productService.getAllProducts();
        model.addAttribute("productes", productes);
        return "catalog"; 
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "search"; // Referencia a search.html en el directorio templates
    }

    @PostMapping("/prodname")
    public String searchProductByName(@RequestParam("name") String name, Model model) {
        Product product = productService.findProductsByName(name);
        model.addAttribute("product", product);
        return "buscar"; // Referencia a buscar.html en el directorio templates
    }
}
