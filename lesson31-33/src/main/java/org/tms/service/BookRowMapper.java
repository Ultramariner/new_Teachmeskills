package org.tms.service;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.tms.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("f_name");
        String genre = rs.getString("f_genre");
        String author = rs.getString("f_author");
        int pages = rs.getInt("f_pages");
        return new Book(name, genre, author, pages);
    }
}
