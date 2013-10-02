/*
 * A multiplication object is built with the Multiplication constructor. 
 * Steps performed:
 * The initial string is fed in at constructor level. 
 * The setter goes through the characters, finds the * or / signs
 * Goes back few indexes to retrieve the first number (until an operator is met)
 * Goes forward few indexed to retrieve the second number (until an operator is met)
 * It calculates all multiplications and divisions
 * and writes it back into the original 'math' string.
 */
package calculator;

/**
 *
 * @author patrick
 */
public class Multiplication {
    
        private char operator;
        private Character test;
        private Character test2;
        private String math = new String ();
        private int startIndex=0;
        private int endIndex=0;
        private int flag=0;

    public Multiplication(String math) {
        this.math = math;
    }

    public Multiplication() {
    }
    
    

    public String setMath(String math) {

                
                
                       
        
        this.math = calcMult (math);
        return math;
        
    }// end set math
    
    
    
    

    public String getMath() {
        return math;
    }
    
    public String calcMult (String math){
                
        for (int i=0; i<math.length();i++){  // loop looking for * or /
             test=math.charAt(i);
             int result=0;// output of multiplication or division
                    
             
                    
             if (test=='*' | test=='/')                    
                    {
                    int a=0; //a=previous number (before the operator)
                    int b=0; //b=next number (after the operator)
   
                    
                    for (int j=i-1;j>=0;j--){  // rerieves number a
                           
                           test2=math.charAt(j);
                           
                           if (!Character.isDigit(test2)){  // until meets previous operator
                               if(test2=='-' && j>=1 && !Character.isDigit(math.charAt(j-1)))// checks if the number is negative (operator sign followed by a negative sign)
                                   continue;
                               a=Integer.parseInt(math.substring(j+1, i));
                               startIndex=j;
                               break;
                           }//end if
                           if (j<=1){// in case this is the first number (at index 0)
                               a=Integer.parseInt(math.substring(0, i));
                               startIndex=0;
                               break;
                           }//end if
                    }// end for loop retrieving 1st number
                        
                    for (int j=i+1;j<math.length();j++){  // retrieves 2nd number
                            
                           test2=math.charAt(j);
                           if (!Character.isDigit(test2)){  // until meets next operator
                               if(test2=='-' && !Character.isDigit(math.charAt(j-1)))// this is to locate negative signs after an operator
                                   continue;
                               b=Integer.parseInt(math.substring(i+1, j));
                               endIndex=j;
                               break;
                           }//end if
                           if (j==math.length()-1){// in case this is the end of the string
                               b=Integer.parseInt(math.substring(i+1, j+1));
                               endIndex=math.length();
                               break; 
                           }//end if    
                            
                    }// end for loop retrieving 2nd number
                        
                    //System.out.println(a);
                    //System.out.println(b);
                    
                    switch (test){
                            case '*': 
                                result=a*b;
                                break;
                            case '/':
                                if (b==0){
                                    System.out.println("\t\t** as it is not possible to divide by 0, we replace the value of the operator by 1 **");
                                    b++;
                                }
                                result=a/b;
                                break;
                    }
                        
                        // writing over math string with result of the operation 
                        // for instance 1+2*3+4 is replaced by 1+6+4
                    if (startIndex==0){// case where multiplication is at the start of the string
                            math = String.valueOf(result).concat(math.substring(endIndex, math.length())); 
//                    }else if (endIndex+1==math.length()){// case where multiplication is at the end of the string => not used
//                            {math = math.substring(0, startIndex+1).concat(String.valueOf(result));
//                            }
                        
                    }else if (result<0){// this is to take care of the coherence of the string when the result is negative
                            if (math.charAt(startIndex)=='-')
                                    math = math.substring(0, startIndex).concat("+").concat(String.valueOf(result*-1)).concat(math.substring(endIndex, math.length()));// for a negatif figure we need to invert the operator sign (ie 1-2*-2 gives 1+4)
                            else
                                    math = math.substring(0, startIndex).concat(String.valueOf(result)).concat(math.substring(endIndex, math.length()));// for a negative figure we get rid of the + sign (ie 1+2*-2 gives 1-4)
                    }else {
                            math = math.substring(0, startIndex+1).concat(String.valueOf(result)).concat(math.substring(endIndex, math.length()));
                    }
                            
                    i--; // back one step to catch cases where there are several multiplications on a row
                        
             } //end if related to multiplication and division
                    
                    
                    
        } // end for loop searching for * or / characters
        
        return math;
    }
          
    
}// end Multiplication class
