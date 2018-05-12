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
public class Module {
    
    private String title;
    private String code;
    private Student[] students;
    
    public Module (String title, String code, int num_students)
    {
        students = new Student[num_students];
        this.title = title;
        this.code = code;
       
    }
    
    public void printModule()
    {
        System.out.println("Name: " + title + " \nCode: " + code );
        
        for (int i = 0 ; i < students.length; i++)
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
        for (int i = 0 ; i < students.length; i++){
            if (null == students[i]){
                students[i] = newStudent;
                break;
            }
        }
    }
    
}
