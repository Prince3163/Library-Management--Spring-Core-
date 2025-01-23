package org.example.configuration;

import org.example.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.example.beans")
public class AppConfig {

//    @Bean
//    @Scope("prototype")
//    public Author author(String name) {
//        return new Author(name);
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Book book(String name ,int price, Author author) {
//        return new Book(name, price, author);
//    }
//
//    @Bean
//    @Scope("prototype")
//    public LibraryImpl library(String name) {
//        return new LibraryImpl(name);
//    }

//    @Bean
//    @Scope("singleton")
//    public LibraryService library1() {
//        return new LibraryService();
//    }
}