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
public class Recipe {
    
    String recipeName;
    ArrayList <Ingredient> list;

    public Recipe(String recipeName, ArrayList<Ingredient> list) {
        this.recipeName = recipeName;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Recipe{" + "recipeName=" + recipeName + ", list=" + list + '}';
    }
    
    
}
