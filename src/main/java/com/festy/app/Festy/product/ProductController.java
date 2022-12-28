package com.festy.app.Festy.product;

import com.festy.app.Festy.category.Category;
import com.festy.app.Festy.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductServices service;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getDashboard(Model model){
        model.addAttribute("products",service.getAllProduct());

        return "ProductDashboard";
    }


    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Product product = service.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "UpdateProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        System.out.println("saving"+product);
        service.addProduct(product);
        return "redirect:/product";
    }
    @GetMapping("/add")
    public String newProduct(Model model, Product product, Category category){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "NewProduct";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
        return "redirect:/product";
    }
}
