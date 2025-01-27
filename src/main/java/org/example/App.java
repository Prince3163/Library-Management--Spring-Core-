package org.example;

import org.example.beans.*;
import org.example.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        int actionNumber;
        String title;
        String price;
        String name;
        LibraryImpl lib;
        Author author;
        Book book;

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        lib= context.getBean(LibraryImpl.class, "Ahmedabad_Lib");
        author= context.getBean(Author.class);
        book = context.getBean(Book.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Library Management :)");

        do{
            System.out.println("\nFollowings are action numbers with description : " +
                    "\n1 -> Add a new book." +
                    "\n2 -> Print all books in library." +
                    "\n3 -> Remove book by title. "+
                    "\n4 -> Is book Exsists by title. " +
                    "\n5 -> Remove all books from library." +
                    "\n6 -> Update book price." +
                    "\n7 -> Get book details by title." +
                    "\n8 -> All books of author by name."+
                    "\n0 -> Exit from app.");

            System.out.print("==> Enter Action number: ");

            try {
                String action = scanner.nextLine();
                actionNumber = Integer.parseInt(action);
            }
            catch (Exception e){
                actionNumber = -1;
            }

            switch (actionNumber){
                case 1: {
                    System.out.print("Enter book Title : ");
                    //scanner.nextLine();
                    title = scanner.nextLine().trim();
                    book.setTitle(title);

                    System.out.print("Enter Author name : ");
                    name = scanner.nextLine().trim();
                    author.setName(name);
                    book.setAuthor(author);

                    System.out.print("Enter book Price in numbers only : ");
                    price = scanner.next().trim();
                    book.setPrice(price);

                    lib.addBook(book);
                    break;
                }

                case 2: {
                    System.out.println("\n==> Collection of our library: ");
                    lib.displayBooks();
                    break;
                }

                case 3: {
                    System.out.print("Enter title of book to remove : ");
                    //scanner.nextLine();
                    title = scanner.nextLine().trim();
                    lib.removeBook(title);
                    break;
                }

                case 4: {
                    System.out.print("Enter title of book to check is exsists : ");
                    //scanner.nextLine();
                    title = scanner.nextLine().trim();
                    lib.isBookExists(title);
                    break;
                }

                case 5:{
                    lib.removeAllBooks();
                    break;
                }

                case 6: {
                    System.out.print("Enter book Title for Update Price : ");
                    //scanner.nextLine();
                    title = scanner.nextLine().trim();

                    System.out.print("Enter new Price in numbers : ");
                    price = scanner.next().trim();

                    lib.updatePrice(title,price);
                    break;
                }

                case 7: {
                    System.out.print("Enter title of book to get details : ");
                    //scanner.nextLine();
                    title = scanner.nextLine().trim();
                    lib.getBookDetails(title);
                    break;
                }

                case 8: {
                    System.out.print("Enter author name and get all books title : ");
                    //scanner.nextLine();
                    name = scanner.nextLine().trim();
                    lib.authorsAllBooks(name);
                    break;
                }

                case 0: {
                    System.out.println("Closing....");
                    break;
                }

                default:{
                    System.out.println("\nInvalid action number!!\n" +
                            "Try with only above mentioned please...");
                }
            }
        }
        while ( actionNumber!=0 );

    }
}
