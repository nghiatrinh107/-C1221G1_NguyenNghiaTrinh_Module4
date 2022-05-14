package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.IMusicGenreService;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;
    @Autowired
    private IMusicGenreService iMusicGenreService;

    @GetMapping(value = {"/list", ""})
    public String goHome(Model model, @PageableDefault(value = 2, sort = {}) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam Optional<String> name) {
        String searchKeyWord = name.orElse("");
        String sortAsc = sort.orElse("");
        model.addAttribute("sort", sortAsc);
        model.addAttribute("musicGenre", this.iMusicGenreService.findAll());
        model.addAttribute("songs", this.iSongService.findAllAndSearch(searchKeyWord, pageable));
        model.addAttribute("search", searchKeyWord);
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        model.addAttribute("musicGenres", this.iMusicGenreService.findAll());
        return "create";
    }
    @PostMapping(value = "/create")
    public String CreateSong(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,Model model){
            if(bindingResult.hasFieldErrors()){
                model.addAttribute("musicGenres", this.iMusicGenreService.findAll());
                return "create";
            }else {
                Song song = new Song();
                BeanUtils.copyProperties(songDto, song);
                model.addAttribute("musicGenres", this.iMusicGenreService.findAll());
                this.iSongService.save(song);
                redirectAttributes.addFlashAttribute("message", "Create OK!");
                return "redirect:/list";
            }

    }
}
