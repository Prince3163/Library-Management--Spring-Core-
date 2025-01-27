package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

@Service
@Scope("prototype")
public class LibraryImpl implements Library{

    private final int indexOfTitle = 0;
    private final int indexOfAuthor = 1;
    private final int indexOfPrice = 2;
    private String libName;

    ArrayList< ArrayList<String> > booklst = new ArrayList<>();
    ArrayList<String> noteBook;

    public LibraryImpl(String name){
        this.libName = name;
    }

    @Override
    public void addBook(Book book) {
        noteBook = new ArrayList<>();

        noteBook.add(book.getTitle());
        noteBook.add(book.getAuthor().getName()) ;
        noteBook.add(book.getPrice());

        booklst.add(noteBook);
    }

    @Override
    public void displayBooks(){
        System.out.println("Books in \""+libName+"\" : ");
        for(ArrayList<String> one : booklst){
            System.out.println(one);
        }
    }

    @Override
    public void removeBook(String title) {

        ArrayList<String> noteBook = findBook(title);

        if( noteBook == null){
            System.out.println("-------Book Not Found!!-------");
        }
        else{
            booklst.remove( noteBook );
            System.out.println("-------Book Removed-------");
            displayBooks();
        }
    }

    @Override
    public void isBookExists(String title) {
        if( findBook(title) == null ) {
            System.out.println("No, \""+title+ "\" is't exists.");
            return;
        }
        System.out.println("Yes, \""+title+ "\" is exists in "+libName);
    }

    @Override
    public void removeAllBooks() {
        System.out.println("Clearing books...");
        booklst.clear();
        System.out.println("-------\nNow Library has ZERO books.\n-------");
    }

    @Override
    public void updatePrice(String title , String newPrice) {
        ArrayList<String> noteBook = findBook(title);
        if( noteBook == null ){
            System.out.println("-------Book Not Found!!-------");
        }
        else{
            noteBook.set(indexOfPrice , newPrice);
            System.out.println("\n-------Price of \""+title+"\" Updated-------");
            displayBooks();
        }
    }

    @Override
    public void getBookDetails(String title) {

        ArrayList<String> book = findBook(title);

        if( book == null ){
            System.out.println("-------Book Not Found!!-------");
        }
        else{
            System.out.println("\nDetails of book:");
            System.out.println("Title : "+book.get(indexOfTitle));
            System.out.println("Author : "+book.get(indexOfAuthor));
            System.out.println("Price : "+book.get(indexOfPrice));
        }
    }

    @Override
    public void authorsAllBooks(String authorName) {
        List<String> authorBooks = new ArrayList<>();

        for(ArrayList<String> book : booklst ){
            if( book.get(indexOfAuthor).equals(authorName) ){
                authorBooks.add( book.get(indexOfTitle) );
            }
        }
        System.out.println("\nAll books By \""+authorName+ "\" are : \n");
        for(int i=0 ; i< authorBooks.size() ; i++){
            System.out.println(i+1 +" "+ authorBooks.get(i) );
        }
    }

    @Override
    public ArrayList<String> findBook(String title){
        for(ArrayList<String> book : booklst ){
            if( book.get(indexOfTitle).equals(title) ){
                return book;
            }
        }
        return null;
    }

    @PostConstruct
    public void init(){
        System.out.println("\nInitializing Library with name = "+libName);
    }

    @PreDestroy
    public  void clean(){
        System.out.println("Destroying ....");
        booklst.clear();
    }

}