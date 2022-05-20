package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    Page<Blog> findAllAndSearch(String searchKeyWord, Pageable pageable);


    Page<Blog> findCategory(String categoryByID, Pageable pageable);
}
