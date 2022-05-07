package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService<Product> {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.delete(id);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Integer id,Product product) {
        iProductRepository.update(id,product);
    }
}
