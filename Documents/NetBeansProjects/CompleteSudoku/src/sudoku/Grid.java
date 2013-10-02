/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import java.util.Random;

/**
 *
 * @author patrick
 */
public class Grid {
    
    Scanner in = new Scanner (System.in);
    
    private int [][] grid = new int [9][9];

    
    public Grid() {//constructor
        for (int i=0 ; i < grid.length ; i++)
            for (int j=0 ; j <grid [i].length ; j++)
                this.grid[i][j]=0;
        setInitialValues();
    }
    
    public Grid (Grid gridToBeCloned) {//constructor cloning grids
        for (int i=0 ; i<gridToBeCloned.grid.length ; i++)
            for (int j=0 ; j<gridToBeCloned.grid[i].length ; j++)
                this.grid[i][j] = gridToBeCloned.grid[i][j];
    }

    public int getGrid(int x, int y) {
        return this.grid[x][y];
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setValue(int x, int y, int value) {
        this.grid [x][y] = value;
    }
    
    public void setValue(int x , ArrayList <Integer> row) {//setting up a row at a time (in the grid creation)
        for (int i=0 ; i<9 ; i++)
        this.grid [x][i]= (int) row.get(i);
    }
     
   
    public void showGrid() {
        for (int i=0 ; i < grid.length ; i++)
           {
               if (((i)%3==0) && (i!=0))
                   System.out.print("\n--------------------------------\n");
               else
                   System.out.print("\n");

               for (int j=0 ; j <grid [i].length ; j++)
               {

                   if (((j)%3==0) && (j!=0))
                       System.out.print(" | ");
                   else
                       System.out.print("  ");
                   System.out.print(grid[i][j]);

               }//end inner for 

           }//end outer for
        
        System.out.print("\n\n");
    
    }//end method
    
    
    
//    public void setInitialValues () {
//        System.out.print("how many numbers are currently on the grid? ");
//        int nbreValues = in.nextInt();
//        
//        for (int i=0 ; i<nbreValues ; i++)
//        {
//            Integer Xcoord;
//            Integer Ycoord;
//            int value;
//            do{
//                System.out.print("Please enter coordinates of the item number "+(i+1)+" in the format x,y ");
//                String coordinates = in.next();
//                String arrayCoord [] = coordinates.split(",");
//
//                System.out.print("And the relevant value ");
//                value = in.nextInt();
//                System.out.print("\n");
//                Xcoord = Integer.parseInt(arrayCoord[0]);
//                Ycoord = Integer.parseInt(arrayCoord[1]);
//            }while (!(((Xcoord>0) && (Xcoord<=9) && (Ycoord>0) && (Ycoord<=9) && (value>0) && (value<=9))));
//            this.grid[Xcoord-1][Ycoord-1]= value;
//        }
//            
//    }//end method
    
    
    public void setInitialValues () {//building new grid
        
        ArrayList <Integer> values = new ArrayList (9);
        ArrayList <Integer> forbidenValues = new ArrayList ();
        int grid [][] = new int [9][9];
        boolean flag=false;
        
        for (int i=0 ; i<9 ; i++)
            values.add(i+1);
        
        
        for (int i=0 ; i<9 ; i++)//go through the rows
        {
           
           do{// until combination of 9 digits fits the rows already in place
               flag=false;
               forbidenValues.clear();//values already in adjacent columns and square 
               Collections.shuffle(values);//randomising values
               
               for (int j=0 ; j<values.size() ; j++)//for each item of the list of possible values we need to check if they fit the existing grid
               {forbidenValues.clear();
                   for (int k=0 ; k<values.size() ; k++)//loading up forbiden values for this cell (values already showing on this column and square
                   {
                       forbidenValues.add(grid[k][j]);
                       forbidenValues.add(grid[i/3*3+k/3][j/3*3+k%3]);
                   }
                   if (forbidenValues.contains(values.get(j)))
                           flag=true;
               }
               
           }while (flag);
           
           for (int a=0 ; a<values.size() ; a++)
               grid[i][a]=values.get(a);

        }
        
        for (int i=0 ; i<9 ; i++)//copy of the array into the actual grid object
            for (int j=0 ; j<9 ; j++)
                this.grid[i][j]=grid[i][j];

            //this.showGrid();
        }
        


    
    public int checkCell (int x, int y){//main goes through each cell and calls this method. takes in coordinates and return a value if found
        ArrayList <Integer> relevantValues = new ArrayList ();
        ArrayList <Integer> possibleValues = new ArrayList ();
        for (int i=0 ; i<9 ; i++)
        possibleValues.add(i, i+1); //the cell can only contain values from 1 to 9
        
        for (int i=0 ; i<relevantValues.size() ; i++)//ensuring arraylist is empty
        relevantValues.remove(0);
        
        if (this.getGrid(x,y)!=0)
            return 0;//the cell is already filled with a value, no need to investigate
        else
        {
            
            for (int i=0 ; i<9 ; i++)//assign all values from horizontal row / vertical column / relevant square into arraylist
            {
                relevantValues.add(this.getGrid(i, y));
                relevantValues.add(this.getGrid(x, i));
                relevantValues.add(this.getGrid((x/3*3+i%3), (y/3*3+i/3)));
            }

            
            for (int i=1 ; i<=9 ; i++)//checks if a number from 1 to 9 is already in the arraylist
            {
                if (relevantValues.contains(i))//if a number is already in the arraylist, it can not be this one because the number can not show twice in a row / column / square
                        continue;
                else{
                    possibleValues.remove(i-1);//if i=8, to remove 8 from the list, it is at index 7
                    //if all values from 1 to 9 are in the relevant values (exept the value we are looking at), then the value we are looking at can be written on the grid
                        if (relevantValues.containsAll(possibleValues))
                        {
                            this.setValue(x, y, i);
                            //showGrid();
                            
                        }
                    possibleValues.add(i-1, i);//writes back the value we removed
                }        
            }
            
        }
            
        
        
        return 0;
    }
    
    public Grid removeDigit () {//removing one digit from a grid (to be invoked until grid is not resolvable)
        int x=0;
        int y=0;
        do{
            //x = (int) Math.random()*9+1;
            x = (int) (Math.random()*9);//range from 0 to 8
            y = (int) (Math.random()*9); 
        }while (this.getGrid(x, y)==0);
        
        this.setValue(x, y, 0);
        
        return this;
    }
    
    
    public boolean checkEquality (Grid other){
        boolean equal = true;
        for (int i=0 ; i<this.grid.length ; i++)
            for (int j=0 ; j<this.grid[i].length ; j++)
                if (this.grid[i][j]!=other.grid[i][j])
                    return false;
            
        
        return equal;
    }
    
}
