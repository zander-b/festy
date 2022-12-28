package com.festy.app.Festy.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public String getDashboard(Model model){
        model.addAttribute("categories",service.getAllCategories());
        return "CategoryDashboard";
    }

    @PostMapping
    public String addCategory(Model model, Category category){
        service.addCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        service.deleteCategory(id);
        return "redirect:/category";
    }
}
