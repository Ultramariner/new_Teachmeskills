package org.tms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tms.Book;
import org.tms.service.BookService;

import javax.validation.Valid;
import java.sql.SQLException;
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
        List<FieldError> fieldErrors;
        if (!result.hasErrors()) {
            bookService.add(book);
        } else {
            fieldErrors = result.getFieldErrors();
            for (FieldError error : fieldErrors) {
                modelAndView.addObject(error.getField(), error.getDefaultMessage());
            }
        }
        modelAndView.setViewName("books");
        return modelAndView;
    }
}
