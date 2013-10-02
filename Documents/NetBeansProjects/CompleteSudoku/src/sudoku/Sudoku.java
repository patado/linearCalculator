/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author patrick
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        boolean similar=false;
        Grid initialGrid = new Grid();//constructor + place initial digits on grid
        //initialGrid.showGrid(); // formatting of grid
        Grid completeGrid = new Grid (initialGrid);//keeps a copy of the complete grid
        Grid resolvableGrid = new Grid (initialGrid);//digits will be removed from this grid while it is still resolvable

        
        similar = false;
        do{
            Grid tryGrid = new Grid (resolvableGrid);//cloning resolvableGrid to keep a reference (if tryGrid is not resolvable, we'll revert to resolvableGrid)
            tryGrid = tryGrid.removeDigit();//removing a random digit from the tryGrid grid
            Grid copyTryGrid = new Grid (tryGrid);

            tryGrid = Admin.ThroughList(tryGrid);

            //Throughlist will try to resolve, but if unable to resolve, will throw back the grid without modification, 
            //hence it the grid passed to ThroughList and return from this method are equal, the grid is not resolvable.
            //In this case resolvableGrid is the grid to be presented to the user. On the other hand, if the tryGrid is resolvable
            //it will be writen into resolvableGrid, and we continue looping.
            if (copyTryGrid.checkEquality(tryGrid))
            {
                System.out.println ("Resolvable Grid");
                resolvableGrid.showGrid();
                similar = true;//exiting loop
            }
            else
            {
                resolvableGrid = copyTryGrid;
            }
            
        }while (!similar);
        
        System.out.println("Press enter to view solution");
        sc.nextLine();
        
        
        int flag=0;
        do{//resolution process 
        initialGrid = Admin.ThroughList(initialGrid);//for each cell, will go through the resolution process (Grid.checkCell)
        flag=Admin.checkIfFinished(initialGrid);    //checks if any cell remain at 0 instead of being populated
        }while (flag==1);
        
        System.out.println("Solution :");
            initialGrid.showGrid();
    }
}
