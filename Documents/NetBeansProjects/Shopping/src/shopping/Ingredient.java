/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 *
 * @author phamon
 */
public class Ingredient extends Home {
    
    String Ingredientname;

    public Ingredient(String Ingredientname) {
        this.Ingredientname = Ingredientname;
    }

    @Override
    public String toString() {
        return "Ingredients{" + "Ingredientname=" + Ingredientname + '}';
    }
    
    
    
}
