package org.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    public ModelAndView add(@Valid Book book, BindingResult result, ModelAndView modelAndView) throws SQLException, ClassNotFoundException {
        if (!result.hasErrors()) {
            bookService.add(book);
        }
        modelAndView.setViewName("books");
        return modelAndView;
    }
}
