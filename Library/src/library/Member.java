/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author phamon
 */
public class Member {
    
    private int id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String county;
    private String country;
    private int age;
    private int existingLoan;
    private double fines;
    private boolean isOverdue;
    private int loanLimit;
    private StringBuilder mailMerge;//=new StringBuilder();
    private boolean subscriptionPaid;
    
    public static final double usualFine = 0.1;
    
    public static final int limitAdult=6;
    public static final int limitChild=4;
    public static int numberOfAdults=0;
    public static int numberOfChildren=0;
    public static int numberOfPeopleWithLoans=0;
    public static int numberOfBooksOut=0;
    

    public int getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(int loanLimit) {
        this.loanLimit = loanLimit;
    }

    public StringBuilder getMailMerge() {
        return mailMerge;
    }

    public void setMailMerge() {
        this.mailMerge = new StringBuilder();
       this.mailMerge.append("\t").append(this.getFirstName()).append(" ").append(this.getLastName()).append(",\n");
        
        if (this.address1 ==null)
        this.address1="";
        if (this.address2 ==null)
        this.address2="";
        if (this.county ==null)
        this.county="";
        if (this.country ==null)
        this.country="";
      
        if (!this.address1.equalsIgnoreCase("n/a") & !this.address1.equalsIgnoreCase("")){
            mailMerge.append("\t").append(this.address1).append("\n");
            }
        if (!this.address2.equalsIgnoreCase("n/a") & !this.address2.equalsIgnoreCase("")){
            mailMerge.append("\t").append(this.address2).append("\n");
            }
        if (!this.county.equalsIgnoreCase("n/a") & !this.county.equalsIgnoreCase("")) 
            mailMerge.append("\t").append(this.county).append("\n");
        if (!this.country.equalsIgnoreCase("n/a") & !this.country.equalsIgnoreCase("")) 
            mailMerge.append("\t").append(this.country).append("\n");
                              
    }
    
    

    
    public Member() {
        
    }
    
    public Member(int id) {
        this.id = id;
    }

    public Member(int id, String name) {
        this.id = id;
        this.firstName = name;
    }
    
    public Member(int id, String name, int age, int loans, double existingFine, boolean isOverdue) {//100,"Fred",16,2,0,false
        this.id = id;
        this.firstName = name;
        this.age=age;
        this.existingLoan=loans;
        this.fines=existingFine;
        this.isOverdue=isOverdue;
        if (age>=18)
            numberOfAdults++;
        else
            numberOfChildren++;
        
        if (loans>0)
            numberOfPeopleWithLoans++;
        
        numberOfBooksOut=numberOfBooksOut+loans;
    }

    public Member(int id, String firstName, String lastName, int age, String address1, String address2, String county, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.county = county;
        this.country = country;
        this.age = age;
        if(this.age>=18){
            this.loanLimit=6;
        }else{
            this.loanLimit=4;
        }
            
        if (age>=18)
            numberOfAdults++;
        else
            numberOfChildren++;
        
    }
    
    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address1=" + address1 + ", address2=" + address2 + ", county=" + county + ", country=" + country + ", age=" + age + ", existingLoan=" + existingLoan + ", fines=" + fines + ", isOverdue=" + isOverdue + ", loanLimit=" + loanLimit +", StringBuilder"+mailMerge+'}';
    }

    public boolean isIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

       
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return firstName;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.firstName = name;
    }

  
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) { 
        if ((this.age<18) & (age>=18)){
        numberOfChildren--;
        numberOfAdults++;
        }
        this.age = age;
    }

    /**
     * @return the existingLoan
     */
    public int getExistingLoan() {
        return existingLoan;
    }

    /**
     * @param existingLoan the existingLoan to set
     */
    public void setExistingLoan(int existingLoan) {
        this.existingLoan = existingLoan;
        numberOfPeopleWithLoans++;
        numberOfBooksOut=numberOfBooksOut+existingLoan;
    }

    /**
     * @return the fines
     */
    public double getFines() {
        return fines;
    }

    /**
     * @param fines the fines to set
     */
    public void setFines(double fines) {
        this.fines = fines;
    }
    
    public void calculateFine(Member suspects){
        if ((suspects.isOverdue) && (suspects.fines==0)){
            setFines(suspects.existingLoan*usualFine);
        }
      }
        
    public void fineReport (Member adultCulprits){
        if ((adultCulprits.age>=18)& (adultCulprits.fines!=0)){
            System.out.println(adultCulprits.toString());
            
        }
    }
        
     public void report (){
         System.out.println("\t\t========================================");
         System.out.println("\t\t========   Adult fines report   ========");
         System.out.println("\t\t========================================");
     }
     
     public static int numberOfMembers (){
         return (numberOfChildren+numberOfAdults);
     }
     
     
     
    }//end class
        
  
    