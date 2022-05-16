package com.codegym.repository;

import com.codegym.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBooks,Integer> {
    BorrowBooks findByBorrowBooksCode(Integer code);
}
