package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping(value = {"/list", ""})
    public String goHome(Model model, @PageableDefault(value = 2,sort = {}) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam Optional<String> name) {
        String searchKeyWord = name .orElse("");
        String sortAsc = sort.orElse("");
        model.addAttribute("sort",sortAsc);
        model.addAttribute("categories",this.iCategoryService.findAll());
        model.addAttribute("blogs", this.iBlogService.findAllAndSearch(searchKeyWord,pageable));
        model.addAttribute("search",searchKeyWord);
        return "list";
    }
    @GetMapping(value = "/detail")
    public String goDetailBlog(@RequestParam Integer id,Model model){
        Blog blog = this.iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
    @GetMapping(value = "/create")
    public String goCreateSong(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories",this.iCategoryService.findAll());
        return "create";
    }
    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create OK!");
        return"redirect:/list";
    }
    @GetMapping(value = "/edit")
    public String goEditSong(@RequestParam Integer id, Model model){
        model.addAttribute("blog",iBlogService.findById(id));
        model.addAttribute("categories",this.iCategoryService.findAll());
        return "edit";
    }
    @GetMapping(value = "/delete")
    public String deleteSong(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete OK!");
        return"redirect:/list";
    }
//    @GetMapping(value = "/search")
//    public String search(@RequestParam String name,Model model){
//        model.addAttribute("blogs",this.iBlogService.findByName(name));
//        return "list";
//    }
}
