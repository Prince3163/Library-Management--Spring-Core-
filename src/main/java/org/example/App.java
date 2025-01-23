package org.example;

import org.example.beans.*;
import org.example.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Author author1 = context.getBean(Author.class,"Prince");
        Author author2 = context.getBean(Author.class,"Patel");

        Book book1 = context.getBean(Book.class ,"Oneee",2550, author1 );
        Book book2 = context.getBean(Book.class ,"Twoooo",999, author1 );
        Book book3 = context.getBean(Book.class ,"Threeee",555, author2 );
        Book book4 = context.getBean(Book.class ,"Fourrr",2550, author1 );
        Book book5 = context.getBean(Book.class ,"Fivee",999, author1 );
        Book book6 = context.getBean(Book.class ,"SIX",555, author2 );

        LibraryImpl lib1= context.getBean(LibraryImpl.class,"Ahmedabad_Lib");
        LibraryImpl lib2= context.getBean(LibraryImpl.class,"Gandhinagar_Lib");
        LibraryImpl lib3= context.getBean(LibraryImpl.class,"Mehsana_Lib");


        lib1.addBook(book1);
        lib1.addBook(book2);
        lib1.addBook(book3);
        lib1.addBook(book4);
        lib1.addBook(book5);
        lib1.addBook(book6);

        lib2.addBook(book1);
        lib2.addBook(book3);
        lib2.addBook(book5);

        lib3.addBook(book2);
        lib3.addBook(book4);
        lib3.addBook(book6);


        System.out.println("Data from Library one : ");
        lib1.displayBooks();

        System.out.println("\nData from Library two : ");
        lib2.displayBooks();

        System.out.println("\nData from Library Three : ");
        lib3.displayBooks();


        //Ignore

        //Phase TWO

//        LibraryService libService = context.getBean(LibraryService.class);
//
//        libService.addBook(book1);
//        libService.addBook(book2);
//        libService.addBook(book3);
//        libService.addBook(book4);
//        libService.addBook(book5);
//        libService.addBook(book6);
//
//        libService.getLibDetails();
    }
}
