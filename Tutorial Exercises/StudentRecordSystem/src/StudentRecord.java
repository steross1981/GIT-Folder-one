/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ste
 */
public class StudentRecord {

    private String name;
    private long id;
    private String course;

    public StudentRecord(String name, long id, String course) {
        this.name = name;
        this.id = id;
        this.course = course;
    }
    
     public void print()
     {
         System.out.println("Student name: " + name + "\nStudent ID: " + id + "\nStudent course: " + course);
     }

}
