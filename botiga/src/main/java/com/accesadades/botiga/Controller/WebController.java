package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.CategoryService;
import com.accesadades.botiga.Service.SubcategoryService;

import java.util.Set;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/catalogo")
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalogo";
    }

    @RequestMapping(value = {"/buscar", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "nombre", required = false) String nombre, Model model) {
        if (nombre != null) {
            Product product = productService.findProductsByName(nombre);
            model.addAttribute("product", product);
        }
        return "buscar"; // Referencia a buscar.html en el directorio templates
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

    @PostMapping("/productos/desar")
    public String saveProduct(@RequestParam("nombre") String nombre,
                              @RequestParam("descripcion") String descripcion,
                              @RequestParam("unidades") long unidades,
                              @RequestParam("precio") float precio,
                              @RequestParam("fabricante") String fabricante,
                              @RequestParam("subcategoria") Long subcategoryId,
                              @RequestParam("categoria") Long categoryId) {
        Subcategory subcategory = subcategoryService.findSubcategoryById(subcategoryId);
        Category category = categoryService.findCategoryById(categoryId);

        Product product = new Product();
        product.setName(nombre);
        product.setDescription(descripcion);
        product.setUnits(unidades);
        product.setPrice(precio);
        product.setCompany(fabricante);
        product.setSubcategory(subcategory);
        product.setCategory(category);  // Añadir categoría al producto
        productService.saveProduct(product);

        return "redirect:/catalogo";
    }
}
