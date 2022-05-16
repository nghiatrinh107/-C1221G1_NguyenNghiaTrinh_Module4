package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow_books")
public class BorrowBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer borrowBooksCode;
    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;
    private Integer status;
    public BorrowBooks() {
    }

    public BorrowBooks(Integer borrowBooksCode, Book book, Integer status) {
        this.borrowBooksCode = borrowBooksCode;
        this.book = book;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBorrowBooksCode() {
        return borrowBooksCode;
    }

    public void setBorrowBooksCode(Integer borrowBooksCode) {
        this.borrowBooksCode = borrowBooksCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
