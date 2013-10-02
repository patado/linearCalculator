/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;

/**
 *
 * @author patrick
 */
public class Brakets {
    
    private String a;
    private String betweenBrakets="";
    private ArrayList<Integer> b = new ArrayList();

    public Brakets(String a) {
       
    }
        
        
    public String calcBrakets (String a){    

     //  a = "3*((5+3)-(8*7)+1(5)(6))+6(8+3)+(7+3)8";  // used as example
       
       System.out.println("\n\tInitial equation\t\t\t\t\t\t\t\t\t"+a);
 
       
       
       for (int i=1; i<a.length();i++){ // rewrites the string with missing '*' signs that we implicitly assume when brakets are following a number or when a closing braket is followed by an opening one
           char x=a.charAt(i);
           if ((x=='(') && (a.charAt(i-1)==')')) // replaces implicit * sign by an explicit one when two brakets are consecutive. for instance replaces (1+2)(3+4) by (1+2)*(3+4)
               a=a.substring(0, i)+"*"+a.substring(i, a.length());
           if ((x==('(')) && (Character.isDigit(a.charAt(i-1))))// replaces implicit * sign by an explicit one when a digit is followed by a braket. for instance replaces 2(3+4) by 2*(3+4)
               a=a.substring(0, i)+"*"+a.substring(i, a.length());
           if ((x==(')')) && (i<a.length()-1) && (Character.isDigit(a.charAt(i+1))))// replaces implicit * sign by an explicit one when a braket is followed by a digit. for instance replaces (3+4)2 by (3+4)*2
               a=a.substring(0, i+1)+"*"+a.substring(i+1, a.length());
       }
      
      
       do{
       for (int i=0; i<a.length();i++){ // retrieves all the operations that are between brakets (as a substring)
           char x=a.charAt(i);
           switch (x){
               case '(':
                   b.add(i);
                   break;
               case ')':
                   betweenBrakets=a.substring(b.get(b.size()-1), i+1);
                   betweenBrakets=betweenBrakets.substring(1, betweenBrakets.length()-1);//removes the brakets before calling the add and mult methods
                   Addition add2 = new Addition();
                   Multiplication mult2 = new Multiplication();
                   int ResultBetweenBrakets=add2.calcResult(mult2.calcMult(betweenBrakets));
                  // System.out.println( "Line 52 "+  betweenBrakets    );
                  // System.out.println( "Line 53 "+ResultBetweenBrakets   );
                   a=a.substring(0,b.get(b.size()-1) )+String.valueOf(ResultBetweenBrakets)+a.substring( i+1 , a.length());
                  // System.out.println( "Line 55 "+a   );
                   i=i-betweenBrakets.length();
                   //b.remove(b.size()-1);
                   break;
                  
           }
       }
    }while (a.indexOf("(")!=-1);
       System.out.println("\tIntermediary result, after the brakets have been removed \t\t\t\t"+a);
       
       return a;
       
    }
}