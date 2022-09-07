package com.tms.lesson4041.repository.impl;

import com.tms.lesson4041.dto.Book;
import com.tms.lesson4041.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private Session session;
    @Autowired
    private Transaction transaction;

    @Override
    public void add(Book book) {
        session.save(book);
        transaction.commit();
    }

    @Override
    public void update(Book book) {
        session.update(book);
        transaction.commit();
    }

    @Override
    public void delete(Long id) {
        Object object = session.load(Book.class, id);
        session.delete(object);
        transaction.commit();
    }

    @Override
    public Book getBookById(Long id) {
        Book book = session.get(Book.class, id);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> list = session.createCriteria(Book.class).list();
        return list;
    }
}