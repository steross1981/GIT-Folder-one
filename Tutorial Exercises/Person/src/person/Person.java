/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author ste
 */
public class Person {

    String name;
    String address;
    char gender;
    int age;
    
    
    public Person(String personName, String personAddress, char personGender, int personAge){
        
        name = personName;
        address = personAddress;
        gender = personGender;
        age = personAge;
               
    }
    

    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public char getGender(){
        return gender;
    }
    
    public int getAge(){
        return age;
    }
    
    public static void main(String[] args){
        
        Person myPerson = new Person("Steven Ross", "16 Celendine Close", 'm', 36);
        
       
        
       System.out.printf("Your name is:  %s",myPerson.name);
       System.out.println();
       System.out.printf("Your address is:  %s",myPerson.address);
       System.out.println();
       System.out.printf("Your gender is:  %s",myPerson.gender);
       System.out.println();
       System.out.printf("Your age is:  %s",myPerson.age);
       System.out.println();
       
        
        
    }
    
    
   
        
  
    
}
