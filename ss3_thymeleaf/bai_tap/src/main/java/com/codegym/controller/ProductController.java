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
    public String goList(Model model) {
        model.addAttribute("products", this.iProductService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg", "OK!");
        return "redirect:/list";
    }
    @PostMapping(value = "/delete")
    public String deleteProduct(@RequestParam Integer id,RedirectAttributes redirectAttributes) {
        this.iProductService.delete(id);
        redirectAttributes.addFlashAttribute("msg","Delete OK!");
        return "redirect:/list";
    }
    @GetMapping(value = "/edit")
    public String goEditProduct(@RequestParam Integer id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        this.iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("msg", "Edit OK!");
        return "redirect:/list";
    }

}
