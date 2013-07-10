/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

//import java.text.DateFormat;
import java.util.Date;
//import java.util.Locale;

/**
 *
 * @author patrick
 */
public class Loans {
    
    private int loanID;
    private int bookID;
    private int memberID;
    private Date dateOfLoan;//http://www.jmdoudoux.fr/java/dej/chap-utilisation_dates.htm
    private Date returnDate;  // derived from date of loan
    private boolean isOverdue;  // derived from date of loan
    
    public static int numberOfBooksOnLoan=0;
    public static int numberOfLoansOverdue=0;

    
    
    @Override
    public String toString() {
        return "Loans{" + "loanID=" + loanID + ", bookID=" + bookID + ", memberID=" + memberID + ", dateOfLoan=" + dateOfLoan + ", returnDate=" + returnDate + ", isOverdue=" + isOverdue + '}';
    }

    
    //constructor
    public Loans(int loanID, int bookID, int memberID, Date dateOfLoan, Date returnDate, boolean isOverdue) {
        this.loanID = loanID;
        this.bookID = bookID;
        this.memberID = memberID;
        this.dateOfLoan = dateOfLoan;
        this.returnDate = returnDate;
        this.isOverdue = isOverdue;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Date getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(Date dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public boolean isIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public static int getNumberOfBooksOnLoan() {
        return numberOfBooksOnLoan;
    }

    public static void setNumberOfBooksOnLoan(int numberOfBooksOnLoan) {
        Loans.numberOfBooksOnLoan = numberOfBooksOnLoan;
    }

    public static int getNumberOfLoansOverdue() {
        return numberOfLoansOverdue;
    }

    public static void setNumberOfLoansOverdue(int numberOfLoansOverdue) {
        Loans.numberOfLoansOverdue = numberOfLoansOverdue;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    
    
    
    
    
}
