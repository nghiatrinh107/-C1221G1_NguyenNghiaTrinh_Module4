package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping(value = {"/list", ""})
    public String goHome(Model model) {
        model.addAttribute("categories",this.iCategoryService.findAll());
        model.addAttribute("blogs", this.iBlogService.findAll());
        return "list";
    }
    @GetMapping(value = "/detail")
    public String goDetailBlog(@RequestParam Integer id,Model model){
        Blog blog = this.iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
}
