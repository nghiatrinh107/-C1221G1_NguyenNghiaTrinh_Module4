package com.codegym.controller;

import com.codegym.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private ITranslateService iTranslateService;
    @GetMapping(value = "/translate")
    public String translateHome(){return "translate";}
    @PostMapping(value = "/translate")
    public String translate(@RequestParam String english, Model model){
        model.addAttribute("result",this.iTranslateService.translate(english));
        return "translate";
    }
}
