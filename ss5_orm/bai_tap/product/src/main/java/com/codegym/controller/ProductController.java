package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"/list", ""})
    public String goHome(Model model) {
        model.addAttribute("products", this.iProductService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateSong(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "Create OK!");
        return"redirect:/list";
    }
    @GetMapping(value = "/edit")
    public String goEditSong(@RequestParam Integer id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }
    @PostMapping(value = "edit")
    public String editSong(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        this.iProductService.update(product);
        redirectAttributes.addFlashAttribute("message", "Update OK!");
        return"redirect:/list";
    }
    @GetMapping(value = "/delete")
    public String deleteSong(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.iProductService.remove(iProductService.findById(id));
        redirectAttributes.addFlashAttribute("message", "Delete OK!");
        return"redirect:/list";
    }
}
