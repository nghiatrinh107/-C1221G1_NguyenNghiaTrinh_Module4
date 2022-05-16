package com.codegym.service.impl;

import com.codegym.model.BorrowBooks;
import com.codegym.repository.IBookRepository;
import com.codegym.repository.IBorrowBookRepository;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBooksService implements IBorrowBooksService {
    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;
    private BorrowBooks borrowBooks;
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public BorrowBooks save(Integer id) {
        if (bookRepository.findById(id).orElse(null).getQuantity() == 0) {
            borrowBooks = new BorrowBooks();
            return borrowBooks;
        } else {
            borrowBooks = new BorrowBooks();
            borrowBooks.setStatus(1);
            borrowBooks.setBorrowBooksCode((int) (Math.random() * 100000));
            borrowBooks.setBook(bookRepository.findById(id).orElse(null));
            this.iBorrowBookRepository.save(borrowBooks);
            return borrowBooks;
        }
    }

    @Override
    public String giveBack(Integer code) {
        borrowBooks = iBorrowBookRepository.findByBorrowBooksCode(code);
        if(borrowBooks == null){
            return "Mã sách không tồn tại";
        }else
        if (borrowBooks.getStatus() == 0) {
            return "Mã này đã trả sách";
        } else {
            borrowBooks.getBook().setQuantity(borrowBooks.getBook().getQuantity() + 1);
            borrowBooks.setStatus(0);
            iBorrowBookRepository.save(borrowBooks);
            return "Trả sách thành công";
        }
    }

}
