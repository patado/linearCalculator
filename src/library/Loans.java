/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

//import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
//import java.util.Locale;

/**
 *
 * @author patrick
 */
public class Loans {
    
    static Scanner in = new Scanner (System.in);
    
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
    public static ArrayList <Loans> activeLoans = new ArrayList();
    public static ArrayList <Loans> archiveLoans = new ArrayList();
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   

    
    //constructor not used
    public Loans(int loanID, int bookID, int memberID, Date dateOfLoan, Date returnDate, boolean isOverdue) {
        this.loanID = loanID;
        this.bookID = bookID;
        this.memberID = memberID;
        this.dateOfLoan = dateOfLoan;
        this.returnDate = returnDate;
        this.isOverdue = isOverdue;
    }

    //constructor
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
        }else{
            this.activeLoan = true;
            activeLoans.add(this);
            System.out.println(this.toString());}
        
    }


    
    
    
     @Override
    public String toString() {
        return "Loans number \t" + loanID + "\n\tbookID \t\t" + bookID + "\t\t\tmemberID \t" + memberID + "\n\tdateOfLoan\t" + sdf.format(dateOfLoan) + "\t\treturnDate\t" + sdf.format(returnDate) + "\n\tisOverdue \t" + isOverdue + "\t\t\tActiveloan?\t"+activeLoan;
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
    
    public static boolean lookUpMemberLoans (int memberID, int option){
        
        boolean found = false;
        boolean flag = false;
        
        L1:
        do{//keeps asking for a return until operator exits with the 0 key
            flag = false;
            found = false;
        for (int i=0 ; i< activeLoans.size() ; i++)
            if (activeLoans.get(i).getMemberID()==memberID){
                found=true;//at least one loan is found
                activeLoans.get(i).setIsOverdue();// updates the overdue field using Today's date
                System.out.println(activeLoans.get(i).toString());}
        
        if (found==false){
            //in.nextLine(); // to flush nextLine()
            System.out.println("Member "+memberID+" does not have active loan at present.\nPress enter to continue");
            String temp=in.nextLine();
            return true;
        }
        
        if (option==2)
            System.out.print("Please enter the relevant loan ID for this return ( 0 to exit )");
        else
            System.out.print("Please select loan ID to be extended ( 0 to exit )");
        int loanPicked = in.nextInt();
        if (loanPicked == 0) 
            return true;// cancel the current return and return to main (to a new menu)

        for (int i=0 ; i<activeLoans.size() ; i++){
            if (activeLoans.get(i).getLoanID() == loanPicked){
                Date date = new Date();
                switch (option){
                    case 2://book is returned
                            Books.freeBook(activeLoans.get(i).getBookID());//sets book object to available
                            activeLoans.get(i).setActiveLoan(false); // change activeloan to inactive on loan object 
                            Member.freeMemberLoan(memberID) ; // update member existing loan
                            activeLoans.get(i).setReturnDate(date);// change return date on loan object to today
                            archiveLoans.add(activeLoans.get(i));// adds the loan to the archives
                            activeLoans.remove(i);// deletes the loan from the active loans.
                            continue L1;
                    case 3://loan is extended by 14days from Today.
                            activeLoans.get(i).setReturnDate(add14Days(date));
                            System.out.println("The loan "+activeLoans.get(i).getLoanID()+" for member id "+activeLoans.get(i).getMemberID()+" is now extended to "+sdf.format(activeLoans.get(i).getReturnDate()));
                            continue L1;
                        }
                    }
                    System.out.println("Please check the input.");
                    
                
                    
        
                    
        }//end switch
        }while (!flag);
        return flag;
    }
    
}
