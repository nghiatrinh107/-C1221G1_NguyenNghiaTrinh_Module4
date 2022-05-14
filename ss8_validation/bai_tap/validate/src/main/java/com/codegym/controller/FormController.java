package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/create")
    public String goCreateSong(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute @Validated UserDto userDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            this.iUserService.save(user);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            return "redirect:/create";
        }


    }

}
