
package library;

import java.util.ArrayList;
import java.util.Scanner;


public class Member {
    
    static Scanner in = new Scanner (System.in);
    
    private int id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String county;
    private String country;
    private int age;
    private int existingLoan;
    private int loanLimit;
    private StringBuilder mailMerge;//=new StringBuilder();
    private boolean subscriptionPaid;
    private double fines;
    private int test;
    
    
    public static final double usualFine = 0.1;
    
    public static final int limitAdult=6;
    public static final int limitChild=4;
    public static int numberOfAdults=0;
    public static int numberOfChildren=0;
    public static int numberOfPeopleWithLoans=0;
    public static int numberOfBooksOut=0;
    public static ArrayList <Member> memberList = new ArrayList();
    public static boolean flag=false;
    public static int nbreBooksRequested;
    

    
    public Member(int id, String name, int age, int loans, double existingFine, boolean isOverdue) {//100,"Fred",16,2,0,false
        this.id = id;
        this.firstName = name;
        this.existingLoan=loans;
        this.fines=existingFine;
        setAge(age);
        if (loans>0)
        numberOfPeopleWithLoans++;
        numberOfBooksOut=numberOfBooksOut+loans;
        memberList.add(this);
    }

    public Member(int id, String firstName, String lastName, int age, String address1, String address2, String county, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.county = county;
        this.country = country;
        setAge(age);
        memberList.add(this);        
    }
    
    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address1=" + address1 + ", address2=" + address2 + ", county=" + county + ", country=" + country + ", age=" + age + ", existingLoan=" + existingLoan + ", loanLimit=" + loanLimit +", StringBuilder"+mailMerge+'}';
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

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

       
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

  
    public int getAge() {
        return age;
    }

    public void setAge(int age) { 
        this.age = age;
        if(this.age>=18){
            this.loanLimit=limitAdult;
            numberOfAdults++;
        }else{
            this.loanLimit=limitChild;
            numberOfChildren++;
        }
    }

    public int getExistingLoan() {
        return existingLoan;
    }

    public void setExistingLoan(int additionalLoan) {
        if ((this.existingLoan == 0) && (additionalLoan != 1))
            numberOfPeopleWithLoans++;// when existing loan moves from 0 to n, the counter of people with loans is incremented
        this.existingLoan += additionalLoan;
        if ((this.existingLoan == 0) && (additionalLoan != 0))
            numberOfPeopleWithLoans++;// if the new existing loan is 0 further to an amendment in the number of loans, it means the member has given back all his books.
        
        if (this.existingLoan<0)
            System.out.println("Please check history for this member as the number of books on loan is incoherent");
        
        numberOfBooksOut += additionalLoan;
    }


    public int getLoanLimit() {
        return loanLimit;
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
    

     
    public static int numberOfMembers (){
         return (numberOfChildren+numberOfAdults);
     }
     
    public static boolean memberStatus(Member memberCheck){
        boolean status=true;
        if (memberCheck.existingLoan>=memberCheck.loanLimit)// not allowed to borrow books if has reached the limit of books
            status=false;
        if (memberCheck.getFines()>0)//not allowed to take books if has an existing fine
            status=false;
        System.out.println("Member name "+memberCheck.getFirstName()+" "+memberCheck.getLastName());
        System.out.println("Existing fines "+memberCheck.fines);
        System.out.println("Books currently borrowed : "+memberCheck.getExistingLoan()+" out of "+memberCheck.loanLimit+ " permitted");
        return status;
    }
    
    public static boolean retrieveMember(int ID){
        flag=false;
        boolean status=true;
        for (int i=0; i<memberList.size() ;i++ ){
                if (memberList.get(i).getId()==ID){
                    status = memberStatus(memberList.get(i));
                    System.out.println("Member is allowed to borrow books? " + status);// invokes member status to get additional details on the member
                    if (status){// if OK to borrow books
                        System.out.print("Number of books requested ? (maximum of "+(memberList.get(i).getLoanLimit()-memberList.get(i).getExistingLoan())+" books) ");
                        nbreBooksRequested = in.nextInt();
                        
                        if (nbreBooksRequested>(memberList.get(i).getLoanLimit()-memberList.get(i).getExistingLoan())){// asking to bypass max number of books if needed
                            System.out.println("\n Warning: ** The number of books requested is greater than the number of books authorised for this loan. **");
                            System.out.print("Please re-enter number of books to overwrite limit, or select a new number of books: ");
                            nbreBooksRequested = in.nextInt();
                        }
                        
                        for (int j=0; j<nbreBooksRequested; j++){// instanciates number of loans requested
                            Loans newLoan = new Loans (memberList.get(i).getId(), memberList.get(i).getAge());
                            memberList.get(i).setExistingLoan(1);// increases loan counter
                            if (j==nbreBooksRequested-1)
                                System.out.println("The number of books out for member "+memberList.get(i).getFirstName()+" "+memberList.get(i).getLastName()+" has been updated to "+memberList.get(i).getExistingLoan());
                        }
                        flag = true;// member is found
                        return flag;// allows main to exit from loop looking for the member
                    }else{// in case the member is not allowed to borrow a book, we ask the operator to acknowledge by pressing 'Enter'
                        System.out.println("Please press enter to continue");
                        String temp=in.nextLine();//stops the program at this stage until operator moves forward
                    }
                    
                    flag=true;// returned to main to exit from loop asking for member id (because it is found)
                    break;
                }
            }
        
        return flag;
    }
     
     
    }//end class
        
  
    