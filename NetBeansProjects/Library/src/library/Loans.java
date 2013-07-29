/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    private boolean activeLoan;// true until book has been returned
    
    
    public static int numberOfBooksOnLoan=0;
    public static int numberOfLoansOverdue=0;
    public static int loanCounter=0;
    public static final int LOANLENGTH=14;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   

    
    //constructor
    public Loans(int loanID, int bookID, int memberID, Date dateOfLoan, Date returnDate, boolean isOverdue) {
        this.loanID = loanID;
        this.bookID = bookID;
        this.memberID = memberID;
        this.dateOfLoan = dateOfLoan;
        this.returnDate = returnDate;
        this.isOverdue = isOverdue;
    }

    public Loans(int memberID, int memberAge) {
        this.loanID = ++loanCounter;
        this.memberID = memberID;
        
        Date date = new Date();
        this.dateOfLoan=date;
        this.returnDate = add14Days(this.dateOfLoan);

        this.setIsOverdue();
        this.bookID = Books.borrowBook(memberAge);
        
        if (this.getBookID() == 0){
            this.activeLoan = false;//sets loan at inactive if it is a cancellation (when book id is set to 0)
            System.out.println("** This loan is now cancelled **");
            for (int i = 0 ; i < Member.memberList.size() ; i++){
                if (Member.memberList.get(i).getId() == this.memberID){
                    Member.memberList.get(i).setExistingLoan(-1);//removes unsuccessfull loan from loancounter
                    break;}
            }
        }else
            this.activeLoan = true;
            
        
        System.out.println(this.toString());
        
    }


    
    
    
     @Override
    public String toString() {
        return "Loans{" + "loanID=" + loanID + ", bookID=" + bookID + ", memberID=" + memberID + ", dateOfLoan=" + sdf.format(dateOfLoan) + ", returnDate=" + sdf.format(returnDate) + ", isOverdue=" + isOverdue + ", Activeloan? "+activeLoan+'}';
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

    public void setIsOverdue() {
        Date date = new Date();
        if (this.returnDate.before(date))
        this.isOverdue = true;
        else 
        this.isOverdue = false;
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

    public boolean isActiveLoan() {
        return activeLoan;
    }

    public void setActiveLoan(boolean activeLoan) {
        this.activeLoan = activeLoan;
    }
    
    
    public static Date add14Days(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, LOANLENGTH);
        return cal.getTime();
        }
    
    
    
}
