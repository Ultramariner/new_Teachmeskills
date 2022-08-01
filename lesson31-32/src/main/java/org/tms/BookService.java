package org.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private Connection connection;

    public void add(Book book) throws SQLException, ClassNotFoundException {
        if (check(book)) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into books (f_name, f_genre, f_author, f_pages) values (?, ?, ?, ?);");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getGenre());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getPages());
            preparedStatement.execute();
        } else {
            throw new ExistSqlException();
        }
    }

    public List<Book> search(String str) throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select distinct * from books where f_name like ? or f_author like ?;");
        str = "%" + str + "%";
        preparedStatement.setString(1, str);
        preparedStatement.setString(2, str);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("f_name");
            String genre = resultSet.getString("f_genre");
            String author = resultSet.getString("f_author");
            int pages = resultSet.getInt("f_pages");
            books.add(new Book(name, genre, author, pages));
        }
        return books;
    }

    public boolean check(Book book) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("select count(*) AS count from books where f_name = ? and f_genre = ? and f_author = ? and f_pages = ?;");
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getGenre());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setInt(4, book.getPages());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getInt("count") > 0;
    }
}
