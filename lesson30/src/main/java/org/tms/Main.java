package org.tms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tms.service.GameService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.tms");
        GameService gameService = context.getBean(GameService.class);

        gameService.game();
    }
}
