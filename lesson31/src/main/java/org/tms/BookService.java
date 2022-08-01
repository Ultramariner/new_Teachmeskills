package org.tms;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public void add(String name, String genre, String author, int pages) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tms?currentSchema=lesson31", "postgres", "password");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into books (f_name, f_genre, f_author, f_pages) values (?, ?, ?, ?);");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, genre);
        preparedStatement.setString(3, author);
        preparedStatement.setInt(4, pages);
        preparedStatement.execute();
    }

    public List<Book> search(String str) throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tms?currentSchema=lesson31", "postgres", "password");
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
}
