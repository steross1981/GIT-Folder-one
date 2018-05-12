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
    
    public Student(String StudentName, String code)
    {
        this.name = StudentName;
        this.id_number = code;
    }
     
    public void setName(String newName)
    {
        this.name = newName;
        
               
    }
            public String getName()
            {
                return name;
            }
    public void setNumber(String newNumber)
    {
        id_number = newNumber;
    }
    
    public String getNumber()
    {
        return id_number;
    }
    
    public void printStudent()
    {
        System.out.println("Name: " + name + "\nID Number: " + id_number);
    }
}
