/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataModel;

import gui.RegisterFrame;

/**This class defines a register and contains methods for setting and returning the registers attributes
 *
 * @author ste
 */
public class Register {

    // the week number for each regiter
    private final int weekNo;
    // module code register is for
    private int moduleCode;
    //whether a student is attending
    private int Attending;
    // the students student number
    private int StudentNO;
   
    /**
     *constructor for register initialises its attributes
     * @param wek this integer parameter defines the week number for the register
     * @param modCode this integer parameter defines the module code that this register is for
     * @param att this integer parameter defines a students attendance 1 refers to present and 0 refers to absent
     * @param num this refers to the student number of the student that is being registered at the time.
     */
    
    public Register( int wek, int modCode, int att, int num) {
    
        weekNo = wek;
        moduleCode = modCode;       
        Attending = att;
        StudentNO = num;
 
    }
    /**
     *returns a student number
     * @return returns the int value of StudentNO
     */
    public int getNum()
    {
        
        return StudentNO;
    }
    /**sets the student number value of StudentNo to the value of num
     *
     * @param num integer value of student number
     */
    public void setNum(int num)
    {
        StudentNO = num;
    }
    /**Returns the week number for the register
     *
     * @return returns the week number
     */
    public int getWeek()
    {
        return weekNo;
    }
    
    /** Returns the module code of the module that the register is for
     *
     * @return returns module code
     */
    public int getCode()
    {
        return moduleCode;
    }
    
    /**sets the value of the module code for the register equal to num
     *
     * @param num returns the module code
     */
    public void setCode( int num)
    {
        moduleCode = num;
    }

    /**returns whether the student has attended that week
     *
     * @return attendance value of 1 or 0
     */
    public int getAttending()
    {
        return Attending;
    }
    
    /**sets the value of attendiing equal to att
     *
     * @param att defines if a student has attended
     */
    public void setAttending(int att)
    {
        Attending = att;
    }            
        
    
    
}
