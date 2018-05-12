package DataModel;

import javax.swing.JOptionPane;

/**
 * defines a student constructor and contains method for retrieving and setting its attributes
 * @author ste
 */
public class Student  {
    protected String enrolledModuleID;

    /**name of student 
     *
     */
    protected String forename;

    /**surname of student
     *
     */
    protected String surname;

    /**students student number
     *
     */
    protected int StudentNo;

    /**
     * whether a student if full or part time
     */
    protected String FullPartTime;

    /** how many sessions have they missed
     *
     */
    protected int missedSessions;

    /** enum of full or part time
     *
     */
    protected HoursOfStudy hours;

    /**
     *
     * @param forn forename of student
     * @param sur surname of student
     * @param stud student number
     * @param hrs enum full part time
     */
    public Student(String forn, String sur, int stud, HoursOfStudy hrs ) {
        
        forename = forn;
        surname = sur;
        StudentNo = stud;
        hours = hrs;
    }
    /**returns forename
     *
     * @return returns forename 
     */
    public String getfName() {
        return forename;
    }
    /** returns surname
     *
     * @return returns surname
     */
    public String getsName() {
        return surname;
    }

    /** returns student number
     *
     * @return returns student number
     */
    public int getNum() {
        return StudentNo;
    }
    /** returns full or part time
     *sets enum to string value to be put into the database
     * @return returns full or part time
     */
    public String getfpart() {
        
        
        switch (hours) {
            case FULL_TIME:
            FullPartTime = "Full Time";
            break;
            case PART_TIME: 
                FullPartTime = "Part Time";
                    
        }
                
        return FullPartTime;
    }

    /** warning displayed if a student misses sessions
     *
     * @param hrs returns enum hrs
     */
    protected void warning(HoursOfStudy hrs)
{
    switch(hrs){
        case PART_TIME:          
    JOptionPane.showMessageDialog(null,"Student "+forename+" "+surname+ " has missed  2 or more sessions");
    break;
        case FULL_TIME:
        JOptionPane.showMessageDialog(null,"Student "+forename+" "+surname+ " has missed 1 or more sessions");
        break;
}

}
}



