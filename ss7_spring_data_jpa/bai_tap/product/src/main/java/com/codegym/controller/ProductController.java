package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ICategoryService;
import com.codegym.service.IProductService;
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
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"/list",""})
    public String goList(Model model,
                         @RequestParam("searchName")Optional<String> name,
                         @RequestParam("searchPrice") Optional<String> price,
                         @RequestParam("searchCategory") Optional<String> category,
                         @RequestParam("sort")Optional<String> sort,
                         @PageableDefault(value = 2,sort = {})Pageable pageable){
        String nameVal=name.orElse("");
        String sortByName=sort.orElse("");
        String categoryFind=category.orElse("%");
        String priceFind=price.orElse("");
        model.addAttribute("categorySearch",categoryFind);
        model.addAttribute("price",priceFind);
        model.addAttribute("nameVal",nameVal);
        model.addAttribute("sort",sortByName);
        model.addAttribute("products",this.iProductService.findAndSearch(nameVal,categoryFind,priceFind,pageable));
        model.addAttribute("categories",this.iCategoryService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateSong(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", this.iCategoryService.findAll());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create OK!");
        return "redirect:/list";
    }

    @GetMapping(value = "/edit")
    public String goEditSong(@RequestParam Integer id, Model model) {
        model.addAttribute("categories", this.iCategoryService.findAll());
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editSong(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Update OK!");
        return "redirect:/list";
    }

    @GetMapping(value = "/delete")
    public String deleteSong(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        this.iProductService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete OK!");
        return "redirect:/list";
    }
}
