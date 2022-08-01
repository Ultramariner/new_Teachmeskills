package org.tms;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ExistSqlException.class)
    public ModelAndView processException(ExistSqlException exc, ModelAndView modelAndView) {
        modelAndView.setViewName("books");
        modelAndView.addObject("error", exc.getMessage());
        return modelAndView;
    }
}
