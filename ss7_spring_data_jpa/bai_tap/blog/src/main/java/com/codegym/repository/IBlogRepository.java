package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(String name,Pageable pageable);
    @Query(value="select * from blog where  category_id = :categoryByID",
            countQuery = "select * from blog where  category_id = :categoryByID",nativeQuery=true)
    Page<Blog> findByCategory(String categoryByID, Pageable pageable);


//    @Query(value="select * from blog where  like :nameVal",
//            countQuery = "select * from blog where name like :nameVal",nativeQuery=true)
//    Page<Blog> findAllBlog(@Param("nameVal") String nameVal, Pageable pageable);

}
