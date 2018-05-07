
package components;

/**
 *
 * @author ste
 */
public class Student {
    
    private String name;
    private String id;
    
    
    
    public Student(String studentName, String studentID)
    {
        name = studentName;
        id = studentID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String studentName)
    {
        name = studentName;
    }
    
    public String getID()
    {
        return id;
    }
    
    public void setID( String studentID)
    {
        id = studentID;
    }
    
    public void printStudent()
    {
         System.out.println("Name: " + name + "Student ID: " + id );
    }
}
