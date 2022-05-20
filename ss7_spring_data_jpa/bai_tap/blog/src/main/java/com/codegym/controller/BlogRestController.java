package com.codegym.controller;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RequestMapping(value = "/blogRest")
@RestController
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2)Pageable pageable, @RequestParam("sort") Optional<String> sort,
                                                  @RequestParam Optional<String> name){
        String searchKeyWord = name .orElse("");
        Page<Blog> blogPage = this.iBlogService.findAllAndSearch(searchKeyWord,pageable);
        if(!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
    @GetMapping(value = "/category")
    public ResponseEntity<Page<Category>> getPageCategory(@PageableDefault(value = 2)Pageable pageable, @RequestParam("sort") Optional<String> sort,
                                                      @RequestParam Optional<String> name){
        String searchKeyWord = name .orElse("");
        Page<Category> categoryPage = this.iCategoryService.findAllSearch(searchKeyWord,pageable);
        if(!categoryPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryPage,HttpStatus.OK);
    }
    @GetMapping(value = "/category/categoryId")
    public ResponseEntity<Page<Blog>> getPageCategoryBlog(@PageableDefault(value = 2)Pageable pageable, @RequestParam("sort") Optional<String> sort,
                                                  @RequestParam Optional<String> category){
        String categoryByID = category.orElse(null);
        Page<Blog> blogPage = this.iBlogService.findCategory(categoryByID,pageable);
        if(!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
    @GetMapping(value = "/detail")
    public ResponseEntity<Blog> getBlog(@RequestParam Optional<Integer> id){
        Integer blogId = id.orElse(null);
        Blog blog = this.iBlogService.findById(blogId);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
//    @PostMapping(value = "/create")
//    public ResponseEntity<List<FieldError>> createBlog(@Validated @RequestBody BlogDto blogDto,
//                                                       BindingResult bindingResult){
//        if(bindingResult.hasFieldErrors()){
//            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
//        }
//        Blog blog = new Blog();
//
//    }

}
