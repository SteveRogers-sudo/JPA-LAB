package com.cg.iter.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.iter.entity.Book;
import com.cg.iter.exception.BookAuthorException;
import com.cg.iter.service.BookAuthorService;
import com.cg.iter.service.BookAuthorServiceImpl;

@SuppressWarnings("unused")
public class UserInterface {

	public static void main(String[] args) throws BookAuthorException{
		// TODO Auto-generated method stub
		do {
			BookAuthorService service=new BookAuthorServiceImpl();
			Scanner sc= new Scanner(System.in);
			int choice = 0;
			//while (true) {
				choice = getChoice(sc);
				switch (choice) {
				case 1:
					//GET ALL BOOK DETAILS
					List<Book> bookList=service.getAllBooksDetail();
					System.out.println("Book Details:");
					System.out.println(bookList);
					break;
				
				case 2:
					//GET ALL BOOKS BY AUTHOR
					System.out.println("Enter Author Name:");
					String authorName=sc.next();
					List<Book> bookByAuthor;
					try {
						bookByAuthor = service.getAllBookByAuthor(authorName);
						System.out.println(bookByAuthor);
					} catch (BookAuthorException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					break;
					
				case 3:
					//GET BOOKS BY PRICE RANGE
					System.out.println("Enter min price");
					int minPrice=sc.nextInt();
					System.out.println("Enter max price");
					int maxPrice=sc.nextInt();
					List<Book> bookByPriceRange;
					try {
						bookByPriceRange = service.getAllBooksInRange(minPrice, maxPrice);
						System.out.println("Book Details:");
						System.out.println(bookByPriceRange);
					} catch (BookAuthorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case 4:
					//GET AUTHORS BY ISBN
					System.out.println("Enter book ISBN");
					int isbn= sc.nextInt();
					String author;
					try {
						author = service.getAuthorsByISBN(isbn);
						System.out.println("Book isbn: "+isbn);
						System.out.println("Author Name :"+author);
					} catch (BookAuthorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case 5:
					//EXIT
					System.out.println("Exiting..");
					System.exit(0);
					break;
					
				default:
					System.out.println("Please choose valid option (1-5)");
					break;	
				}
			}while(true);
	}
	
		
			private static int getChoice(Scanner sc) {
				int choice = 0;
			System.out.println("Enter your option");
			System.out.println("1)Query all books");
			System.out.println("2)Query all books written by given author name");
			System.out.println("3)Query all books in particular price range");
			System.out.println("4)Query author Name by book id");
			System.out.println("5)Exit");
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Enter valid choice");
				sc.hasNextLine();
			}
			return choice;
	}
}


