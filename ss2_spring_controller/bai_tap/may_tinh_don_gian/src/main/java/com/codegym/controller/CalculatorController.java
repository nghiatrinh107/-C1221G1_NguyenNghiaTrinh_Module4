package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
 @Autowired
 private ICalculatorService iCalculatorService;
 @GetMapping(value = "/calculator")
public String getHome(){
return "index";
 }
 @PostMapping(value = "/calculator")
 public String calculator2Num(@RequestParam(name = "number1") Integer a,
                              @RequestParam(name = "number2") Integer b,
                              @RequestParam(name = "calculator") String c,
                              Model model){
 model.addAttribute("result",this.iCalculatorService.calculator(a,b,c));
 return "index";
 }
}
