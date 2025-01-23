package org.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Author {
    private String name;
    List<Book> books = new ArrayList<>();

    public Author(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}