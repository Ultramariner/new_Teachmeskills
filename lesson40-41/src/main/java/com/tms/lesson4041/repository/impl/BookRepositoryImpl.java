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
    private SessionFactory factory;

    @Override
    public void add(Book book) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Object object = session.load(Book.class, id);
        session.delete(object);
        transaction.commit();
        session.close();
    }

    @Override
    public Book getBookById(Long id) {
        Session session = factory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = factory.openSession();
        List<Book> list = session.createCriteria(Book.class).list();
        session.close();
        return list;
    }
}