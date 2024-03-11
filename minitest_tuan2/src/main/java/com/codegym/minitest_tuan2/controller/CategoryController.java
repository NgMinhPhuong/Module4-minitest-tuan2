package com.codegym.minitest_tuan2.controller;

import com.codegym.minitest_tuan2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("showAllCategory")
    public String showCategory(Model model){
            model.addAttribute("categories", iCategoryService.findAll());
        return "/showCategory";
    }
    @GetMapping("category/{id}")
    public String findById(Model model, @PathVariable Long id){
        model.addAttribute("categories", iCategoryService.findById(id));
        return "/showCategory";
    }
}
