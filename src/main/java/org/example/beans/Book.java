package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Book {
    private Author author;
    private String title;
    private int price;

    public Book(String title, int price , Author author) {
        //Do this Firsttt
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Author getAuthor(){
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}