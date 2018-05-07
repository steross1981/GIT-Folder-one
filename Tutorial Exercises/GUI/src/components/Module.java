/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javaapplication25.Student;

/**
 *
 * @author ste
 */
public class Module {
    
    private String title;
    private String code;
    private Student[] students;
    public Module( String moduleTitle, String moduleCode, int num_students)
    {
        students = new Student[num_students];
        title = moduleTitle;
        code = moduleCode;
    }
  
    public void printModule()
    {
        System.out.println("Module Details" + "\nModule Title: " + title + "\nModule Code: " + code + "Module ID: ");
        System.out.println("  ");
        System.out.println("Students: ");
        System.out.println("------------------------------------------------------------");
        for( int i = 0; i < students.length; i++)
        {
            Student current = students[i];
            
            if (null != current)
            {
                current.printStudent();
            }
        }
    }
    
    public void addStudent( final Student newStudent)
    {
        for (int i = 0; i<students.length; i++)
        {
            if (null == newStudent)
            {
                students [i] = newStudent;
                break;
            }
        }
    }
}
