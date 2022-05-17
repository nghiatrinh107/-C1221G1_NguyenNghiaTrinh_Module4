package com.codegym.controller;

import com.codegym.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller

public class CartController {
    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute(name = "cart",required = false)CartDto cartDto){
        model.addAttribute("cart",cartDto);
        return "cart";
    }
}
