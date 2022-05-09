package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping(value = {"/list", ""})
    public String goHome(Model model) {
        model.addAttribute("songs", this.iSongService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateSong(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("message", "Create OK!");
        return"redirect:/list";
    }

    @GetMapping(value = "/edit")
    public String goEditSong(@RequestParam Integer id, Model model){
        model.addAttribute("song",iSongService.findById(id));
        return "edit";
    }
    @PostMapping(value = "edit")
    public String editSong(@ModelAttribute Song song,RedirectAttributes redirectAttributes){
        this.iSongService.update(song);
        redirectAttributes.addFlashAttribute("message", "Update OK!");
        return"redirect:/list";
    }
    @GetMapping(value = "/delete")
    public String deleteSong(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.iSongService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete OK!");
        return"redirect:/list";
    }
}
