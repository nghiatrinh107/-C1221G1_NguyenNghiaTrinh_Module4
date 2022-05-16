package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllAndSearch(String searchKeyWord, Pageable pageable) {
        return iBookRepository.findAllByNameContaining(searchKeyWord, pageable);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public String save(Integer id) {
        if (findById(id).getQuantity() == 0) {
            return "Hết sách không thể mượn";
        } else {
            findById(id).setQuantity(findById(id).getQuantity() - 1);
            iBookRepository.save(findById(id));
            return "Mượn sách thành công";
        }
    }




}
