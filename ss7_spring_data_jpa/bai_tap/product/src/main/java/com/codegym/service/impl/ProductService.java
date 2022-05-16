package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;




    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAndSearch(String nameVal, String categoryFind, String priceFind, Pageable pageable) {
        return this.iProductRepository.findAndSearch("%"+nameVal+"%",categoryFind,"%"+priceFind+"%",pageable);
    }
}
