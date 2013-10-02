/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;

/**
 *
 * @author phamon
 */
public class Individual {
    
    String name;
    ArrayList <Ingredient> allergies;
    boolean vegetarian;
    
    Individual(String name){
        this.name = name;
        this.allergies = null;
    }

    public Individual(String name, ArrayList<Ingredient> allergies) {
        this.name = name;
        this.allergies = allergies;
    }

    public Individual(String name, ArrayList<Ingredient> allergies, boolean vegetarian) {
        this.name = name;
        this.allergies = allergies;
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "Individual{" + "name=" + name + ", allergies=" + allergies + ", vegetarian=" + vegetarian + '}';
    }

    
    
    
}
