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
    
    private String moduleCode;
    private String moduleTitle;
    private int numberOfStudents;
    public Student[] students;
    


public Module( String modCode, String modTitle, int numStudents)
{
moduleCode = modCode;
moduleTitle = modTitle;
numberOfStudents = numStudents;
students = new Student[numStudents];
}

public String getCode()
{
    return moduleCode;
}

public void setCode( String mCode)
{
    moduleCode = mCode;
}

public String getTitle()
{
    return moduleTitle;
}

public void setTitle(String mTitle)
{
    moduleTitle = mTitle;
}
public int getNumber()
{
    return numberOfStudents;
}

public void printModule()
{
    System.out.println("Module Code: " + moduleCode  + "\nModule Title" + moduleTitle);
    System.out.println("-----------------------------------------");
    for (int i = 0; i< students.length; i++)
    {
        Student currentStudent = students[i];
        if (students[i] != null){
        students[i].printStudent();
        }
    }
    System.out.println();
}

public void addStudent(final Student newStudent)
{
for (int i = 0; i < students.length; i++)
{
    if ( null == students[i])
    {
        students[i] = newStudent;
    }
}
}

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}