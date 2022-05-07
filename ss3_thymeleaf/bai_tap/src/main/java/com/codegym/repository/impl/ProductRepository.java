package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"kẹo",50000,"nhập khẩu","USA"));
        productList.add(new Product(2,"nước ngọt",20000,"nhập khẩu","USA"));
        productList.add(new Product(3,"bánh",70000,"nhập khẩu","USA"));
        productList.add(new Product(4,"nước trái cây",150000,"nhập khẩu","USA"));
        productList.add(new Product(5,"nước mía",80000,"nhập khẩu","USA"));
        productList.add(new Product(6,"khẩu trang",30000,"nhập khẩu","USA"));
    }
    private static Integer temp;
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        temp = (productList.get(productList.size()-1).getId())+1;
        product.setId(temp++);
        productList.add(product);
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId().equals(id)){
                productList.remove(i);
            }
        }
    }

    @Override
    public Product findById(Integer id) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId().equals(id)){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Integer id,Product product) {
        for (int i = 0; i <productList.size() ; i++) {
            if(productList.get(i).getId().equals(id)){
                productList.get(i).setNameProduct(product.getNameProduct());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setDescription(product.getDescription());
                productList.get(i).setManufacturer(product.getManufacturer());
            }
        }
    }
}
