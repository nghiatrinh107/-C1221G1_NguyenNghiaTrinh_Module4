package com.codegym.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SandwichController {
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String home() {
        return "index";
    }
    @RequestMapping(value = "/condiments",method = RequestMethod.POST)
    public String save(@RequestParam("condiments") Optional<String[]>  condiment, Model model) {
        if(condiment.isPresent()){
            model.addAttribute("condiment",condiment);
        }else {
            model.addAttribute("mess","Nonnnnn");
        }

        return "condiments";
    }
}
