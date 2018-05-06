/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import DataModel.Programme;
import DataModel.Register;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ste
 */
public class ProgrammeConnection extends DBConnection {
    
    /**connects to database
     *
     * @param dbName database to connect to
     */
    public ProgrammeConnection(final String dbName)
    {
        this.connectDatabase(dbName);
    }
    
    /** inserts a programme into the database
     *
     * @param programme programme to insert
     */
    public void insertProgramme(Programme programme) {
        final String insertStmt = "INSERT INTO cis4005.PROGRAMME(ProgrammeCode,Level,Title) VALUES(?,?,?)";

        try {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);

            pstmt.setInt(1, programme.getCode());
            pstmt.setInt(2, programme.getLevel());
            pstmt.setString(3, programme.getTitle());
         ;
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Exception when update register: " + sqle.toString());
        }

    }
      
        /**
     * Adds students number and module number to the StudentModule table of the
     * database
     *
     * @param moduleCode module code to add
     * @param programmeCode programme code to add
     */
    public void AddModuleProgramme(final int moduleCode, int programmeCode) {

        //creates SQL statement to insert a studentNO and moduleCode into the STUDENTMODULE table. 
        //values to be inserted are assigned to (?,?) values
        final String insertStmt = "INSERT INTO cis4005.PROGRAMMEMODULE(ProgrammeCode,ModuleCode) VALUES(?,?)";

        try {
            // This statement defines a Prepared statement that will insert values into the insertStmt String. 
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            // This statement sets the values of the prepared statement to the parameters passed into the brackets.  
            //These refer to the column name and number
            pstmt.setInt(1, programmeCode);
            pstmt.setInt(2, moduleCode);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "You have Selected an Invalid number Please Try Again" + sqle);
        } catch (Exception e) {
            System.out.println("Exception" + e.toString());
        }

    }
    
    /** prints programme info to a jtable
     *
     * @param jtable jtable results are displayed to
     */
    public void printProgrammeInfo(JTable jtable) {
        try{

// Defines a String SQL statement to print Module title, Module Code and level from the MODULE table

        final String retrieveQuery = "SELECT * from cis4005.PROGRAMME ORDER BY PROGRAMMECODE";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        jtable.setModel(DbUtils.resultSetToTableModel(output));
        
              
            
        } catch (Exception sqle) {
            System.out.println("Exception when printing information: " + sqle.toString());
        }

    }
        
    /** prints programme info to a jtable
     *
     * @param jtable table to print programme info to
     */
    public void printProgrammeModuleInfo(JTable jtable) {
        try{

// Defines a String SQL statement to print Module title, Module Code and level from the MODULE table

        final String retrieveQuery = "SELECT * from cis4005.PROGRAMMEMODULE ORDER BY PROGRAMMECODE";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        jtable.setModel(DbUtils.resultSetToTableModel(output));
        
              
            
        } catch (Exception sqle) {
            System.out.println("Exception when printing information: " + sqle.toString());
        }

    }

}
