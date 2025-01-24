package org.example.beans;

import java.util.ArrayList;

public interface Library {

    public void addBook(Book book);
    public void removeBook(String title);
    public void isBookExists (String title);
    public void removeAllBooks();
    public void updatePrice(String title, String newPrice);
    public void getBookDetails(String title);
    public void displayBooks();
    public void authorsAllBooks(String authorName);
    public ArrayList<String> findBook(String title);
}