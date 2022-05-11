package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> findAllAndSearch(String searchKeyWord, Pageable pageable);
    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);
}
