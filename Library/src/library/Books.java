/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author patrick
 */
public class Books {
    
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean isAgeRestricted;
    private String shelfReference;
    private boolean isAvailable=true;
    private boolean isLoanRestricted;
    private boolean isAlreadyBooked=false;
    private int numberOfSimilarBooks=1;
    
    public static int numberOfBooks=0;

    public Books(int bookID, String title, String author, String genre, boolean isAgeRestricted, String shelfReference, boolean isLoanRestricted) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAgeRestricted = isAgeRestricted;
        this.shelfReference = shelfReference;
        this.isLoanRestricted = isLoanRestricted;
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
    
    
    
    
    
}
