package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    
    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);

    Page<Product> findAllAndSearch(String name, String price, String category, Pageable pageable);
}
