package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingEmailController {
  @GetMapping(value = "/create")
    public String goCreateSetting(Model model){
        model.addAttribute("email",new Email());
      return "home";
  }
  @PostMapping (value = "/create")
  public String createSetting(@ModelAttribute("email") Email email,Model model){
      model.addAttribute("languages",email.getLanguages());
      model.addAttribute("size",email.getPageSize());
      model.addAttribute("spams",email.isSpamsFilter());
      model.addAttribute("signature",email.getSignature());
      return "setting";
  }

}
