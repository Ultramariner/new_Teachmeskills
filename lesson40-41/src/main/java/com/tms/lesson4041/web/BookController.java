package com.tms.lesson4041.web;

import com.tms.lesson4041.dto.Book;
import com.tms.lesson4041.repository.BookRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(id)).withSelfRel();
        Book book = bookRepository.getBookById(id);
        book.add(link);
        return book;
    }

    @GetMapping
    public List<Book> getAll() {
        List<Book> list = bookRepository.getAllBooks();
        for (Book book: list) {
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(book.getId())).withSelfRel();
            book.add(link);        //link добавляется, но в ответе отображается []
        }
        return bookRepository.getAllBooks();
    }

    @PostMapping("/{name}/{author}")
    public void addBook(@PathVariable String name, @PathVariable String author) {
        bookRepository.addBook(new Book(name, author));
    }

    @PostMapping("/{id}/{name}/{author}")
    public void updateBook(@PathVariable Long id, @PathVariable String name, @PathVariable String author) {
        bookRepository.updateBook(new Book(id, name, author, new Date()));
    }

    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "no with such id")
    })
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteBookById(id);
    }
}
