package com.tms.lesson4041.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private long id;
    private String name;
    private String author;
    private Date date;
}
