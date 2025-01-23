package org.example.beans;


import java.util.Map;

public interface Library {

    public void addBook(Book book);
    public void removeBook(Book book);
    public boolean idBookExists (String title);
    public void removeAllBooks();
    public void updatePrice(String title, int newPrice);
    public void getBook(String title);
    public void displayBooks();
    public void getCollecetionOfAuthor(String authorName);


    //public Map getBookDetails();
    public void displayWithMap();
}