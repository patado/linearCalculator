
package library;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author phamon
 */
public class Library {

    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        boolean flag=false;
        int menuChoice=0;
        int memberID=0;
        
        Member[] Group = new Member[19];
        Group[0] = new Member(96, "Francis", "Owen", 34, "Killybeg Row", "Ballyclough", "Cork", "Ireland");
        Group[1] = new Member(97, "Edward", "Young", 37, "14 Malahide Street", "", "Louth", "Ireland");
        Group[2] = new Member(98, "Andy", "Kerwin", 14, "14 Malahide Street", "Drogheda", "n/a", "Ireland");
        Group[3] = new Member(99, "Katie", "Byrne", 14, "Main St.", "Mallow", null, "Ireland");
        Group[4] = new Member(100, "Fred", 16, 2, 0, false);
        Group[5] = new Member(101, "Frank", 34, 0, .5, true);
        Group[6] = new Member(102, "Anne", 37, 7, 0, true);
        Group[7] = new Member(103, "Adrian", 14, 6, 0, false);
        Group[8] = new Member(104, "Kate", 34, 6, 0, true);
        Group[9] = new Member(105, "Carlos", 6, 2, 0, false);
        Group[10] = new Member(106, "Pete", 34, 0, .5, true);
        Group[11] = new Member(107, "Georgina", 35, 7, 0, true);
        Group[12] = new Member(108, "Tristan", 44, 3, 0, false);
        Group[13] = new Member(109, "Kate", 34, 6, 0, true);
        Group[14] = new Member(110, "Alexander", 20, 2, 0, false);
        Group[15] = new Member(111, "Francis", 34, 6, .5, true);
        Group[16] = new Member(112, "Edward", 37, 7, 1.75, true);
        Group[17] = new Member(113, "Andy", 14, 6, .75, false);
        Group[18] = new Member(114, "Katie", 14, 6, 2.00, true);
        
        Books[] bk= new Books [6];
        //int bookID, String title, String author, String genre, boolean isAgeRestricted, String shelfReference, boolean isLoanRestricted 
        bk[0] = new Books (0,"Dummy loan", "Dummy loan", "Dummy loan", false, "Dummy loan", false);
        bk[1] = new Books (1,"Anna O.", "Freud","Psychology", true, "Psycho100", false); 
        bk[2] = new Books (2,"Moby Dick", "Herman Melville","Adventure", false, "Adventure160", false); 
        bk[3] = new Books (3,"Candid", "Voltaire","Phylosophy", false, "Phylo100", false); 
        bk[4] = new Books (4,"Les fleurs du mal", "Baudelaire","Poetry", false, "Poetry100", false); 
        bk[5] = new Books (5, "La peste", "Camus", "Classics", false, "Classics120", false);
        


        
        System.out.println("Total number of members " + Member.numberOfMembers());
        System.out.println("Total number of adult members " + Member.numberOfAdults);
        System.out.println("Total number of under-aged members " + Member.numberOfChildren);
        System.out.println("Total number of people with loans out " + Member.numberOfPeopleWithLoans);
        
        
        do{//restarts whole program after each operation
        do{// shows menu until correct option is picked
        System.out.println("\nMenu:");
        System.out.println("1 - Record new loan");
        System.out.println("2 - Take in return");
        System.out.println("3 - Extend loans");
        System.out.println("4 - Reserve a book");
        System.out.println("5 - Run stats report");
        System.out.println("6 - Record new member");
        System.out.println("7 - Record new book");
        System.out.println("8 - Exit");      
        System.out.print("Choice : ");
        menuChoice = in.nextInt();
        }while ((menuChoice<1) || (menuChoice>8));
        
        switch (menuChoice){
            case 1:// register new loan
                System.out.println("\nLoan registration");
                do{
                    memberID = retrieveID();
                    flag=Member.retrieveMember(memberID);// retrieve member locates the member in the arraylist and call member status for additional information.
                }while (!flag);// keeps looping while the member id is not found. 
                break;
            case 2:// take in return of books
                System.out.println("\nReturn of books");
                memberID = retrieveID();
                Loans.lookUpMemberLoans (memberID , menuChoice);
                break;
            case 3:// Extend loan
                System.out.println("\nLoan extension");
                memberID = retrieveID();
                Loans.lookUpMemberLoans (memberID , menuChoice);
                break;
            case 4:// reserve a book
                System.out.println("\nReservation of books");
                break;
            case 5:// run stats report
            case 6:// record new member
            case 7:// record new book
            default://corresponds to value 8, exit
        }//end SWITCH
        }while (menuChoice !=8);//exit is the option number 8
    }// end main
    
    public static int retrieveID (){
        Scanner in = new Scanner (System.in);
        System.out.print("Please insert the member id: ");
        int ID = in.nextInt();
        return ID;
    }
    
}// end class
