package org.tms;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ExistsException.class)
    public String processException(ExistsException exc, Model model) { //Почему-то не работает с ModelAndView
        model.addAttribute("error", exc.getMessage());
        return "books";
    }
}
