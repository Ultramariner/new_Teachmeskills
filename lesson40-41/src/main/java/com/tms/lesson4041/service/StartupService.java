package com.tms.lesson4041.service;

import com.tms.lesson4041.dto.Book;
import com.tms.lesson4041.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class StartupService {

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void init() {


        Book book = new Book("First", "Auth");
        Book book2 = new Book("Second", "Auth2");
        bookRepository.add(book);
        bookRepository.add(book2);
    }
}
