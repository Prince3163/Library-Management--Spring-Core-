package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Book {
    private Author author;
    private String title;
    private String price;

    public Book(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String  price) {
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public Author getAuthor(){
        return author;
    }
}