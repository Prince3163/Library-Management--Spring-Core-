package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class LibraryImpl implements Library{

    private int bookId=1000;
    public Map<Integer ,Book> bookRack = new HashMap();

    private String name;
    private List<Book> books ;

    @Autowired
    private ApplicationContext context;

    public LibraryImpl(String name){
        this.name = name;
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        bookRack.put( ++bookId , book);
    }

    @Override
    public void displayBooks(){
        for(Book book : books ){
            System.out.print("Books from "+name+" : ");
            System.out.print(book.getTitle());
            System.out.print("\t");
            System.out.print(book.getPrice());
            System.out.print("\t");
            System.out.print(book.getAuthor().getName());
            System.out.println("\n");
        }
    }

    //Igrnor Following, Temp Logics done..
    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public boolean idBookExists(String title) {
        for(Book book: books){
            if( book.getTitle().equals(title) ){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAllBooks() {
        books.clear();
    }

    @Override
    public void updatePrice(String title , int newPrice) {
        for(Book book : books ){
            if ( book.getTitle().equals(title)){
                book.setPrice(newPrice);
            }
        }
    }

    @Override
    public void getBook(String title) {
        boolean flag = false;
        for(Book book : books ){
            if ( book.getTitle().equals(title)) {
                flag = true;
                System.out.println(book.getTitle());
                System.out.println(book.getPrice());
                System.out.println(book.getAuthor().getName());
                // break;
            }
        }
        if(! flag)
            System.out.println("Book Not Found!!!");
    }

    @Override
    public void getCollecetionOfAuthor(String authorName) {
        List<String> authorBooks = new ArrayList<>();
        for(Book book : books ){
            if ( book.getAuthor().getName().equals(authorName) ) {
               authorBooks.add(book.getTitle());
            }
        }
        System.out.println("All books By "+authorName+ " are : "+authorBooks);
    }


    @Override
    public void displayWithMap(){
        //System.out.println(bookRack.entrySet());
        for(Map.Entry<Integer,Book> entry : bookRack.entrySet()){
            System.out.print("Book : "+entry.getKey() );
            System.out.print("\t");
            System.out.print(entry.getValue().getTitle());
            System.out.print("\t");
            System.out.print(entry.getValue().getPrice());
            System.out.print("\t");
            System.out.print(entry.getValue().getAuthor().getName());
            System.out.println("\n");
        }
    }

}