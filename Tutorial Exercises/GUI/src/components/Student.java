/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author ste
 */
public class Student {
    
   private String name;
    private String id_number;
    
    public Student(String StudentName, String StudentIDNumber){
        name = StudentName;
        id_number = StudentIDNumber;
        
    }
    
    public void setName(String setName)
    {
        name = setName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setNumber( String setNumber)
    {
        id_number = setNumber;
    }
    
    public String getNumber()
    {
        return id_number;
    }
    
    public void printStudent()
    {
        System.out.println("Student name: " + name + "/n StudentID: " + id_number);
    }
    
    
    
}
