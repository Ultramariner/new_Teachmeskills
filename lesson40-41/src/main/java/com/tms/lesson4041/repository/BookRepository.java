package com.tms.lesson4041.repository;

import com.tms.lesson4041.dto.Book;

import java.util.List;

public interface BookRepository {

    void add(Book book);
    void update(Book book);
    void delete(Long id);

    Book getBookById(Long id);
    List<Book> getAllBooks();
}
