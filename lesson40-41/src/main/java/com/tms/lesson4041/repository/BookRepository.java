package com.tms.lesson4041.repository;

import com.tms.lesson4041.dto.Book;

import java.util.List;

public interface BookRepository {

    void addBook(Book book);
    void updateBook(Book book);
    void deleteBookById(Long id);

    Book getBookById(Long id);
    List<Book> getAllBooks();
}
