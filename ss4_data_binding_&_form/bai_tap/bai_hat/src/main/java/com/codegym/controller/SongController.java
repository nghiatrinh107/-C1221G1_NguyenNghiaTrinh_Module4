package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping(value = {"/list",""})
    public  String goHome(Model model){
    model.addAttribute("song",this.iSongService.findAll());
    return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes){
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("msg","OK!");
        return "redirect:/list";
    }
}
