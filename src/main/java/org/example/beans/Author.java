package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Author {
    private String name;

    public void setName(String name){ this.name = name; }
    public String getName(){
        return name;
    }
}