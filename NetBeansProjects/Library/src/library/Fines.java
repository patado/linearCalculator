/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author patrick
 */
public class Fines {

    private boolean isOverdue;
    
    
    public void calculateFine(Member suspects){
      
      }
        
    public void fineReport (Member adultCulprits){
        if ((adultCulprits.getAge()>=18)& (adultCulprits.getFines()!=0)){
            System.out.println(adultCulprits.toString());
            
        }
    }
    
    public void report (){
         System.out.println("\t\t========================================");
         System.out.println("\t\t========   Adult fines report   ========");
         System.out.println("\t\t========================================");
     }
    
}
