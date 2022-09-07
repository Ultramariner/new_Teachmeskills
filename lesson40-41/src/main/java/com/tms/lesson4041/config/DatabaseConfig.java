package com.tms.lesson4041.config;

import com.tms.lesson4041.dto.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class DatabaseConfig {

    @Value("${hibernate.connection.driver_class}")
    private String driver;
    @Value("${hibernate.connection.url}")
    private String url;
    @Value("${hibernate.connection.username}")
    private String username;
    @Value("${hibernate.connection.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;

    @Bean
    Configuration configuration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", driver);
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", username);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.dialect", dialect);
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.addAnnotatedClass(Book.class);
        return configuration;
    }

    @Bean
    SessionFactory factory(Configuration configuration) throws HibernateException {
        return configuration.buildSessionFactory();
    }

    @Bean
    Session session() {
        return factory(configuration()).openSession();
    }

    @Bean
    Transaction transaction() {
        return session().beginTransaction();
    }
}
