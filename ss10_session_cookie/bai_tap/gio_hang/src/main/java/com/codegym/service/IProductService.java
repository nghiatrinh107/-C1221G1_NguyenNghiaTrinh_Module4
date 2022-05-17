package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAllAndSearch(String searchKeyWord, Pageable pageable);

    Optional<Product> findById(Integer id);
}
