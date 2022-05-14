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

    @GetMapping(value = {"/list", ""})
    public String goHome(Model model, @PageableDefault(value = 2, sort = {}) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam("searchName") Optional<String> searchName,
                         @RequestParam("searchPrice") Optional<String> searchPrice,
                         @RequestParam("searchCategory") Optional<String> searchCategory) {
        String name = searchName.orElse("");
        String price = searchPrice.orElse("");
        String category = searchCategory.orElse("");
        String sortAsc = sort.orElse("");
        model.addAttribute("sort", sortAsc);
        model.addAttribute("categories", this.iCategoryService.findAll());
        model.addAttribute("products", this.iProductService.findAllAndSearch(name, price, category, pageable));
        model.addAttribute("searchName", name);
        model.addAttribute("searchPrice", price);
        model.addAttribute("searchCategory", category);
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
