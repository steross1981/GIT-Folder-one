 
package components;

/**
 *
 * @author ste
 */
import DataModel.Module;
import DataModel.Register;
import DataModel.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 * @author ste
 *This class creates a connection to the database
 * it contains methods for inserting and deleting a student from a database
 * it contains methods for selecting  and printing out student information
 * 
 */
public class StudentConnection extends DBConnection {

    private Register register;
    private Student student;
    
    /**
     *connects to database
     * @param dbName Name of database
     */
    public StudentConnection(final String dbName) {
        this.connectDatabase(dbName);

    }
    
    /**inserts students forename surname student number and hours of study into the database 
     * defines string SQL statement
     * defines a Prepared statement 
     * gets the values of the prepared statement to the parameters passed in
     * @param student Student to be inserted to database
     */
    public void insertStudent( Student student) {
        // defines string SQL statement
        final String insertStmt = "INSERT INTO cis4005.STUDENT( ForeName, Surname,StudentNO, FullPartTime) Values (?,?,?,?)";
  
        try {
             // This statement defines a Prepared statement that will insert values into the insertStmt String. 
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
//convert value to int
int stu = student.getNum();
String gns = Integer.toString(stu);
                       // This statement sets the values of the prepared statement to the parameters passed into the brackets.  
            //These refer to the column name and number   
            pstmt.setString(1, student.getfName());
            pstmt.setString(2, student.getsName());
            pstmt.setString(3, gns);
            pstmt.setString(4, student.getfpart());
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Exception when inserting student record: " + sqle.toString());
        }
    }
    
    /**deletes a students information from the database
     *defines string SQL statement
     * defines a Prepared statement 
     * gets the values of the prepared statement to the parameters passed in
     * executes statement
     * @param studentID student students number parameter
     */
    public void deleteStudent(final String studentID) {
// defines string SQL statement
        final String deleteStmt = "DELETE FROM CIS4005.STUDENT WHERE StudentNO = ?";

        try {
               // This statement defines a Prepared statement that will insert values into the insertStmt String. 
            PreparedStatement pstmt = getConnection().prepareStatement(deleteStmt);
              // This statement sets the values of the prepared statement to the parameters passed into the brackets.  
            //These refer to the column name and number  
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Exception when deleting student record: " + sqle.toString());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    /** returns a string value of StudentID based on  String arguments passed into parameter
     * defines string SQL statement
     * defines a Prepared statement 
     * gets the values of the prepared statement to the parameters passed in
     * executes statement
     * @param StudentNO student number
     * @return returns students student number
     */
    public String[] getStudentInfoByStudentNO(final String StudentNO) {
        String[] data = new String[3];
        ResultSet studentRS = null;
        // defines string SQL statement
        final String getQuery = "SELECT FirstName, Surname, StudentNO, FullPartTime FROM cis4005.STUDENT WHERE StudentNO = ?";
        try {
            // This statement defines a Prepared statement that will insert values into the insertStmt String. 
            PreparedStatement pstmt = getConnection().prepareStatement(getQuery);
                // This statement sets the values of the prepared statement to the parameters passed into the brackets.  
            //These refer to the column name and number
            
            pstmt.setString(1, StudentNO);
            studentRS = pstmt.executeQuery();
        } catch (SQLException sqle) {
            System.out.println("Excpetion trying to retrieve Student data: " + sqle.toString());

        }

        try {
            //executes while there is an instance of  StudentRS and sets the values of data array 
            while ((null != studentRS) && (studentRS.next())) {
                String sid = studentRS.getString(1);
                String fname = studentRS.getString(2);
                String sname = studentRS.getString(3);
                String pcode = studentRS.getString(4);
                String fpart = studentRS.getString(5);

                data[0] = sid;
                data[1] = fname;
                data[2] = sname;
                data[3] = pcode;
                data[4] = fpart;

            }
        } catch (SQLException sqle) {
            System.out.println("Error finding Student: " + sqle.toString());
        }
        return data;
    }

    /** returns string array of student id
     * @param jtable jtable to print results to`    
     * 
     */
    public void getAllStudentIDs(JTable jtable) {
      
        // a vector array to store the string values of stuid representing student ids
      
        try
        {
          
// defines string SQL statement
        final String retrieveQuery = "SELECT ID from cis4005.STUDENT";
        // sets query equal to defined SQL statement
        this.setQuery(retrieveQuery);
        this.runQuery();
        // sets value of output to results gained from query
        ResultSet output = this.getResultSet();
        
            
       
            jtable.setModel(DbUtils.resultSetToTableModel(output));
   
        } catch (Exception e) {
            System.out.println("Exception when getting all student IDs: " + e.toString());
        }
  
    }

    /**
     * gets results of STUDENT table and displays results to a table
     * @param jtable to display information to 
     */
    public void fetchStudent(JTable jtable) {
        try {
            
            // instantiates a new StudentConnection and connects to the database
            StudentConnection sc = new StudentConnection("cis4005");
            // assigns retrieve query String value
            final String retrieveQuery = "SELECT * from cis4005.STUDENT ORDER BY STUDENTNO";
           // sets query = to created retrieve query
            sc.setQuery(retrieveQuery);
            // query executed
            sc.runQuery();
            // resultset gained from query assigned to ResultSet ouput
            ResultSet output = sc.getResultSet();
            // jtabl populated with ResultSet data
            jtable.setModel(DbUtils.resultSetToTableModel(output));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    
}
