package com.tms.lesson4041.web;

import com.tms.lesson4041.dto.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public Book getAll() {
        Book book = new Book();
        return book;
    }
}
