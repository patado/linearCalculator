/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author phamon
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Member[] Group = new Member[19];
        Group[0] = new Member(111, "Francis", "Owen", 34, "Killybeg Row", "Ballyclough", "Cork", "Ireland");
        Group[1] = new Member(112, "Edward", "Young", 37, "14 Malahide Street", "", "Louth", "Ireland");
        Group[2] = new Member(113, "Andy", "Kerwin", 14, "14 Malahide Street", "Drogheda", "n/a", "Ireland");
        Group[3] = new Member(114, "Katie", "Byrne", 14, "Main St.", "Mallow", null, "Ireland");
        Group[4] = new Member(100, "Fred", 16, 2, 0, false);
        Group[5] = new Member(101, "Frank", 34, 0, .5, true);
        Group[6] = new Member(102, "Anne", 37, 7, 0, true);
        Group[7] = new Member(103, "Adrian", 14, 6, 0, false);
        Group[8] = new Member(104, "Kate", 34, 6, 0, true);
        Group[9] = new Member(105, "Carlos", 6, 2, 0, false);
        Group[10] = new Member(106, "Pete", 34, 0, .5, true);
        Group[11] = new Member(107, "Georgina", 35, 7, 0, true);
        Group[12] = new Member(108, "Tristan", 44, 6, 0, false);
        Group[13] = new Member(109, "Kate", 34, 6, 0, true);
        Group[14] = new Member(110, "Alexander", 16, 2, 0, false);
        Group[15] = new Member(111, "Francis", 34, 6, .5, true);
        Group[16] = new Member(112, "Edward", 37, 7, 1.75, true);
        Group[17] = new Member(113, "Andy", 14, 6, .75, false);
        Group[18] = new Member(114, "Katie", 14, 6, 2.00, true);
        
        Books[] bk= new Books [5];
        ////int bookID, String title, String author, String genre, boolean isAgeRestricted, String shelfReference, boolean isLoanRestricted 
        bk[0] = new Books (1,"Anna O.", "Freud","Psychology", true, "Psycho100", false); 
        bk[1] = new Books (2,"Moby Dick", "Herman Melville","Adventure", false, "Adventure160", false); 
        bk[2] = new Books (3,"Candid", "Voltaire","Phylosophy", false, "Phylo100", false); 
        bk[3] = new Books (4,"Les fleurs du mal", "Baudelaire","Poetry", false, "Poetry100", false); 
        bk[4] = new Books (5, "La peste", "Camus", "Classics", false, "Classics120", false);
        


        StringBuilder ctcDetails[] = new StringBuilder[Group.length];


        for (int i = 0; i < Group.length; i++) {

            Group[i].setMailMerge();
            ctcDetails[i] = Group[i].getMailMerge();
            System.out.println(Group[i].getMailMerge());
            System.out.println(ctcDetails[i].toString());
        }//end for

        System.out.println("Total number of members " + Member.numberOfMembers());

    }// end main
}// end class
