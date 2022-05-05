package com.codegym.controller;

import com.codegym.model.ToKhaiYTe;
import com.codegym.service.IToKhaiYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToKhaiYTeController {
    @Autowired
    private IToKhaiYTeService iToKhaiYTeService;

    @GetMapping(value = {"/tokhai", ""})
    public String goToKhai(Model model) {
        model.addAttribute("toKhai", new ToKhaiYTe());
        return "home";
    }
    @PostMapping(value = {"/tokhai", ""})
    public String createToKhai(@ModelAttribute ToKhaiYTe toKhaiYTe,Model model){
        this.iToKhaiYTeService.save(toKhaiYTe);
        model.addAttribute("toKhai",iToKhaiYTeService.getToKhai());
        return "redirect:display";
    }
}

