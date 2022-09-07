package com.tms.lesson4041.service;

import com.tms.lesson4041.dto.Book;
import com.tms.lesson4041.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class StartupService {

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void init() {


        Book book = new Book(1, "First", "Auth", new Date());
        bookRepository.add(book);
    }
}
