package com.tms.lesson4041.web;

import com.tms.lesson4041.dto.Book;
import com.tms.lesson4041.repository.BookRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    @Tag(name = "Find book by id", description = "Find book by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "book found", content = @Content(schema = @Schema(implementation = Book.class)))
    })
    public ResponseEntity<Book> getBook(@PathVariable Long id) {

        //здесь вызывать метод создания link-и у класса Book или создавать её в конструкторе класса?
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(id)).withSelfRel();

        Book book = bookRepository.getBookById(id);
        book.add(link);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    @Tag(name = "Find all books", description = "Find all books")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "books found", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Book.class))))
    })
    public ResponseEntity<List<Book>> getAll() {
        List<Book> list = bookRepository.getAllBooks();
        for (Book book: list) {
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBook(book.getId())).withSelfRel();
            book.add(link);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    @Tag(name = "Add book", description = "Add book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "book added", content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "500", description = "book with such id already exist", content = @Content(schema = @Schema(implementation = Book.class)))
    })
    public ResponseEntity<Book> addBook(@RequestParam String name, @RequestParam String author) {
        Book book = new Book(name, author, new Date());
        bookRepository.add(book);
        return ResponseEntity.ok(book);
    }

    @PostMapping()
    @Tag(name = "Update book", description = "Update book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "book updated", content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "500", description = "no book with such id", content = @Content(schema = @Schema(implementation = Book.class)))
    })
    public ResponseEntity<Book> updateBook(@RequestParam String id, @RequestParam String name, @RequestParam String author) {
        Book book = new Book(id, name, author, new Date());
        bookRepository.update(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Delete book", description = "Delete book by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "book deleted", content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "500", description = "no book with such id", content = @Content(schema = @Schema(implementation = Book.class)))
    })
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookRepository.getBookById(id);
        bookRepository.delete(id);
        return ResponseEntity.ok(book);
    }
}
