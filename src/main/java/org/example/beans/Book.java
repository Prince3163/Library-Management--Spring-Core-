package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Book {
    private Author author;
    private String title;
    private String price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String  price) {
        this.price = price;
    }

    public void setAuthor(Author  author) {
        this.author = author;
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