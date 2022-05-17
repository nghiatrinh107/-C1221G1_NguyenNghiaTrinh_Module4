package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }


    @GetMapping(value = {"/list", ""})
    public String goHome(Model model, @PageableDefault(value = 6, sort = {}) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam Optional<String> name) {
        String searchKeyWord = name.orElse("");
        String sortAsc = sort.orElse("");
        model.addAttribute("sort", sortAsc);
        model.addAttribute("products", this.iProductService.findAllAndSearch(searchKeyWord, pageable));
        model.addAttribute("search", searchKeyWord);
        return "list";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,@SessionAttribute("cart") CartDto cartDto){
        Optional<Product> productOptional = iProductService.findById(id);
        if(productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
