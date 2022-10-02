package com.tms.lesson4041.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor    почему-то не коздаются конструкторы
@Entity
public class Book extends RepresentationModel<Book> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String author;
    private Date date;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, Date date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }
}
