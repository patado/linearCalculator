/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author patrick
 */
public class Addition {
    
    private String mathAdd;
    private int result=0;
    private String [] breakDownArray;

    public Addition() {
    }
    
    

    public Addition(String math) {
        this.mathAdd = math;
    }
    
    
    @Override
    public String toString() {
        return "Addition{" + "mathAdd=" + mathAdd + ", result=" + result + ", breakDownArray=" + breakDownArray + '}';
    }
    

    public int getResult() {
        return result;
    }

    public int setResult(String math) {
        this.result = calcResult(math);        
        return result;
    }

    
    public int calcResult(String math){
        
        math=math.replace("-", "+-");
        if (math.charAt(0)=='+')
                math=math.substring(1, math.length());// case where the first figure was negative and got replace by +- in line 45, just removing the initial + sign
        
                
        breakDownArray=math.split("\\+",-1);
        
               
        for (String x: breakDownArray)
        result+=Integer.parseInt(x);
        
        
        
        return result;
        
    }
    
    
}
