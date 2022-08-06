package org.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.tms.Book;
import org.tms.ExistsException;

import java.sql.*;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RowMapper<Book> rowMapper;

    public void add(Book book) throws SQLException, ClassNotFoundException {
        if (check(book) == 0) {
            jdbcTemplate.update("insert into books (f_name, f_genre, f_author, f_pages) values (?, ?, ?, ?);", book.getName(), book.getGenre(), book.getAuthor(), book.getPages());
        } else {
            throw new ExistsException("Such book already added");
        }
    }

    public List<Book> search(String str) throws SQLException, ClassNotFoundException {
        str = "%" + str + "%";
        List<Book> books = jdbcTemplate.query("select distinct f_name, f_genre, f_author, f_pages from books where f_name like ? or f_author like ?;", rowMapper, str, str);
        return books;
    }

    public int check(Book book) throws SQLException, ClassNotFoundException {
        int count = jdbcTemplate.queryForObject("select count(*) AS count from books where f_name = ? and f_genre = ? and f_author = ? and f_pages = ?;", Integer.class, book.getName(), book.getGenre(), book.getAuthor(), book.getPages());
        return count;
    }
}
