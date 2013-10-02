/*  2 steps:
 * 1) Calculte multiplications and divisions first
 * for instance 1+3/2+1*2  > calcultes 3/2 and 1*2 first and replace in string => leaves additions
 * 2) Calculates remaining additions using a var.. arg
 */
package calculator;
import java.util.Scanner;
/**
 *
 * @author patrick
 */
public class Calculator {

   
    public static void main(String[] args) {
      
        int answer=0;
        
        Scanner sc=new Scanner(System.in);

        String math = new String ();

                
                System.out.print("please enter the operation in the format '1+2*3..'. Valid inputs include integers and the following signs +-/*()==> ");

                math= sc.next();

                if (math.charAt(math.length()-1)=='=')// removes sign '=' if present
                    math=math.substring(0,math.length()-1);
                
                Brakets z= new Brakets(math);
                math= z.calcBrakets(math);
                
                Multiplication mult = new Multiplication (math);// takes care of all multiplication showing in the string and replace the relevant results in the string
                mult.setMath(math);
                
                System.out.println("\tThe multiplications and divisions are now performed. Your operation is equivalent to :\t"+mult.getMath());
                math=mult.getMath();
                
                                
                Addition add = new Addition(math);// takes care of the additions left in the string and produce final result
                answer=add.calcResult(math);
                
                System.out.println("\n\tThe final result is .. "+answer+"\n");
                
                //Brakets z= new Brakets("");
                
    }// end main
   
    
}// end class

