package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BorrowBooks;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowBooksService iBorrowBooksService;

    @GetMapping(value = {"/list", ""})
    public String goHome(Model model, @PageableDefault(value = 2, sort = {}) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam Optional<String> name) {
        String searchKeyWord = name.orElse("");
        String sortAsc = sort.orElse("");
        model.addAttribute("sort", sortAsc);
        model.addAttribute("books", this.iBookService.findAllAndSearch(searchKeyWord, pageable));
        model.addAttribute("search", searchKeyWord);
        return "list";
    }

    @GetMapping(value = "/borrow")
    public String goBorrow(@RequestParam Integer id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "borrow";
    }

    @PostMapping(value = "/borrow")
    public String borrow(@RequestParam Integer id
            , RedirectAttributes redirectAttributes,Model model) {
        redirectAttributes.addFlashAttribute("codes",this.iBorrowBooksService.save(id).getBorrowBooksCode());
        redirectAttributes.addFlashAttribute("message", this.iBookService.save(id));
        return "redirect:/list";
    }
    @PostMapping(value = "/giveback")
    public String giveBack(@RequestParam Integer code,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message",this.iBorrowBooksService.giveBack(code));
        return "redirect:/list";
    }
    @ExceptionHandler(Exception.class)
    public String handlerException(){
        return "error";
    }
}
