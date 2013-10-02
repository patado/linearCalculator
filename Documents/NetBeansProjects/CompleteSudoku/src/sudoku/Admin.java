/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author patrick
 */
public class Admin {
    
    public static Grid ThroughList (Grid initialGrid){
    for (int i=0 ; i<9 ; i++)  //81 cells in total (9*9)
            for (int j=0 ; j<9 ; j++)
                initialGrid.checkCell(i, j);
    
    return initialGrid;
    }
    
    public static int checkIfFinished (Grid initialGrid){
        int flag=0;
        for (int n=0 ; n<9 ; n++)
            for (int m=0 ; m<9 ; m++)
                if(initialGrid.getGrid(n, m)==0)//if any cell remains at 0, the resolution is not finished
                {
                    flag=1;
                    break;
                }
        return flag;
    }
    
    
    
}
