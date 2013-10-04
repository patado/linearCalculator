/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phamon
 */
public class Individual {
    
    Scanner sc = new Scanner (System.in);
    static ArrayList <Individual> family = new ArrayList();
    
    String name;
    ArrayList <Ingredient> allergies;
    boolean vegetarian;
    
    Individual(){
        initGuest();
    }
    
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

    public void initGuest (){
        System.out.print("\nAt present ");
        for (int i=0 ; i<family.size() ; i++)
            System.out.print((family.get(i).name)+", ");
        if (family.size()>1)
            System.out.print("are");
        else if (family.isEmpty())
            System.out.print("nobody is");
        else
            System.out.print("is");
            
        System.out.println(" living at home. ");
        
        if (family.size()>1)
        {
            System.out.println("\nDo you want to remove / add people?");
            System.out.println("type 1 to add");
            System.out.println("type 2 to remove");
            System.out.println("type 0 to exit");
        }
        else
        {
            System.out.println("Do you want to add people?");
            System.out.println("type 1 to add");
            System.out.println("type 0 to exit");
        }
        
        int optionAddPeople = sc.nextInt();
        
        switch (optionAddPeople){
            case 0: return;
            case 1: addPeople();
                break;
            case 2: removePeople();
        }
        
            
    }
    
    public void addPeople(){
        System.out.println("How many people are there at home?");
        int numberPeople = sc.nextInt();
        for (int i=0 ; i<numberPeople ; i++)
        {
            System.out.println("\nName of the individual?");
            String name = sc.next();
            System.out.println("If "+name+" is subject to allergies, please enter all relevant numbers");
            System.out.println("1. Peanuts");
            System.out.println("2. Other nuts");
            System.out.println("3. Eggs");
            System.out.println("4. Milk");
            System.out.println("5. Fish");
            System.out.println("6. Shellfish");
            System.out.println("7. Soy");
            System.out.println("8. Wheat");
            System.out.println("0. No allergy");
            String allergy = sc.next();
            
            ArrayList <Ingredient> allergyArrayList = new ArrayList ();
            for (int j=0 ; j<allergy.length() ; j++)
            {
               switch (allergy.charAt(j))
               {
                   case '1':allergyArrayList.add(new Ingredient ("Peanut"));
                       break;
                   case '2':allergyArrayList.add(new Ingredient ("Nut"));
                       break;
                   case '3':allergyArrayList.add(new Ingredient ("Egg"));
                       break;
                   case '4':allergyArrayList.add(new Ingredient ("Milk"));
                       break;
                   case '5':allergyArrayList.add(new Ingredient ("Fish"));
                       break;
                   case '6':allergyArrayList.add(new Ingredient ("Shellfish"));
                       break;
                   case '7':allergyArrayList.add(new Ingredient ("Soy"));
                       break;
                   case '8':allergyArrayList.add(new Ingredient ("Wheat"));
                       break;
               }
            }
            
            System.out.println("Is "+name+" a vegetarian? (yes/no)");
            String vegString = sc.next();
            
            boolean veg=false;
            if (vegString.equals("Yes") | vegString.equals("yes") | vegString.equals("y") | vegString.equals("Y"))
                veg=true;
            
            Individual person = new Individual(name, allergyArrayList, veg);
            family.add(person);
        }
        
        for (int i=0 ; i<family.size() ; i++)
            System.out.print(family.get(i).toString());
    
    }
    
    public void removePeople(){
    
    }
    
}
