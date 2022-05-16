package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllAndSearch(String searchKeyWord, Pageable pageable);

    Book findById(Integer id);

    String save(Integer id);

}
