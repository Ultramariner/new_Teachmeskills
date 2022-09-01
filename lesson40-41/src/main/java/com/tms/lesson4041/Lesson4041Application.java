package com.tms.lesson4041;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Lesson4041Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson4041Application.class, args);
    }

}
