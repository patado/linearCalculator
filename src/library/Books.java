/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author patrick
 */
public class Books {
    
    static Scanner in = new Scanner (System.in);
    
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean isAgeRestricted;
    private String shelfReference;
    private boolean isAvailable;
    private boolean isLoanRestricted;
    private boolean isAlreadyBooked=false;
    private int numberOfSimilarBooks=1;//needed?
    
    public static final int AGELIMIT=18;
    
    public static int numberOfBooks=0;
    public static ArrayList <Books> bookList = new ArrayList();
    
    

    public Books(int bookID, String title, String author, String genre, boolean isAgeRestricted, String shelfReference, boolean isLoanRestricted) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAgeRestricted = isAgeRestricted;
        this.shelfReference = shelfReference;
        this.isLoanRestricted = isLoanRestricted;
        this.isAvailable=true;
        this.isAlreadyBooked=false;
        bookList.add(this);
    }

    
    @Override
    public String toString() {
        return "Books{" + "bookID=" + bookID + ", title=" + title + ", author=" + author + ", genre=" + genre + ", isAgeRestricted=" + isAgeRestricted + ", shelfReference=" + shelfReference + ", isAvailable=" + isAvailable + ", isLoanRestricted=" + isLoanRestricted + ", isAlreadyBooked=" + isAlreadyBooked + ", numberOfSimilarBooks=" + numberOfSimilarBooks + '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isIsAgeRestricted() {
        return isAgeRestricted;
    }

    public void setIsAgeRestricted(boolean isAgeRestricted) {
        this.isAgeRestricted = isAgeRestricted;
    }

    public boolean isIsAlreadyBooked() {
        return isAlreadyBooked;
    }

    public void setIsAlreadyBooked(boolean isAlreadyBooked) {
        this.isAlreadyBooked = isAlreadyBooked;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isIsLoanRestricted() {
        return isLoanRestricted;
    }

    public void setIsLoanRestricted(boolean isLoanRestricted) {
        this.isLoanRestricted = isLoanRestricted;
    }

    public static int getNumberOfBooks() {
        return numberOfBooks;
    }

    public static void setNumberOfBooks(int numberOfBooks) {
        Books.numberOfBooks = numberOfBooks;
    }

    public int getNumberOfSimilarBooks() {
        return numberOfSimilarBooks;
    }

    public void setNumberOfSimilarBooks(int numberOfSimilarBooks) {
        this.numberOfSimilarBooks = numberOfSimilarBooks;
    }

    public String getShelfReference() {
        return shelfReference;
    }

    public void setShelfReference(String shelfReference) {
        this.shelfReference = shelfReference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    public static int borrowBook(int age){//takes in age of member and return book id
        boolean isFound=false;
        do{
            System.out.print("Please enter book ID to process the loan (0 to cancel): ");
            int bookRequested = in.nextInt();
            if (bookRequested==0)
                return 0;
            for (int i=0; i<bookList.size() ;i++ ){
    // ==== NN add conditions for loan restriction, already booked ====
                    if ((bookList.get(i).getBookID()==bookRequested)&& (bookList.get(i).isIsAvailable())){//NN add more conditions here
                        //checking age restriction
                        if ((age<AGELIMIT) && (bookList.get(i).isAgeRestricted)){
                            System.out.println("This loan is not possible due to age restriction");
                            return 0;
                        }
                        //change status to not available
                        bookList.get(i).setIsAvailable(false);
                        System.out.println("The status of book "+bookList.get(i).getTitle()+" is now on loan");
                        return bookList.get(i).getBookID();
                    }
            }
        }while (!isFound);
    return 0;//not used => loops until book is found anyway.
    }//end borrowBook method
    
    
    public static void freeBook (int bookID){
        for (int i=0 ; i<bookList.size() ; i++){
            if ((bookList.get(i).getBookID() == bookID) && !(bookList.get(i).isIsAvailable())){
                // this method frees one book that has this ID and is currently at unavailable 
                // not necessarily the book that the member took (if 2 books have the same ID and are on loan at the same time)
                // however, the overall number of books available and on loan will remain coherent because loans and books are processed separatly.
                bookList.get(i).setIsAvailable(true);// book is now available
                System.out.println ("The status of book "+bookList.get(i).getTitle()+" is now set to available for loan.");
                break;
            }// end if 
        }// end for loop
    }// end freeBook method
    
}
