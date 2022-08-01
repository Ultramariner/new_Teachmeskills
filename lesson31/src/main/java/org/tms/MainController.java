package org.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class MainController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ModelAndView view(ModelAndView modelAndView) throws SQLException {
        modelAndView.setViewName("books");
        return modelAndView;
    }

    @GetMapping(path = "/search")
    public ModelAndView search(@RequestParam("searchExpression") String searchExpression, ModelAndView modelAndView) throws SQLException, ClassNotFoundException {
        List<Book> books = bookService.search(searchExpression);
        modelAndView.setViewName("books");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @PostMapping(path = "/add")
    public ModelAndView add(@RequestParam("name") String name, @RequestParam("genre") String genre, @RequestParam("author") String author, @RequestParam("pages") int pages, ModelAndView modelAndView) throws SQLException, ClassNotFoundException {
        bookService.add(name, genre, author, pages);
        modelAndView.setViewName("books");
        return modelAndView;
    }
}
