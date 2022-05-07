package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService<Product> {
    List<Product> findAll();

    void save(Product product);

    void delete(Integer id);

    Product findById(Integer id);

    void update(Integer id,Product product);
}
