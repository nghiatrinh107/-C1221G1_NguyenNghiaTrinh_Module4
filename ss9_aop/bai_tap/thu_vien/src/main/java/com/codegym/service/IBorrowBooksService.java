package com.codegym.service;

import com.codegym.model.BorrowBooks;

public interface IBorrowBooksService {
    BorrowBooks save(Integer id);

    String giveBack(Integer code);
}
