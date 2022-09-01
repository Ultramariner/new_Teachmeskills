package com.tms.lesson4041.repository.impl;

import com.tms.lesson4041.dto.Book;
import com.tms.lesson4041.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public void add(Book book) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
    }
}