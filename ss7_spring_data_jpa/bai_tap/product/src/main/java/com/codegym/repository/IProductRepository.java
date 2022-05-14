package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value="select * from product where `name` like :searchName and price like :searchPrice and category_id like :searchCategory" ,
            countQuery="select * from product where name like :searchName and price like :searchPrice and category_id like :searchCategory",nativeQuery=true)
    Page<Product> findAndSearch(@Param("searchName") String searchName, @Param("searchPrice") String searchPrice, @Param("searchCategory") String searchCategory, Pageable pageable);

}
