/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import DataModel.Module;
import gui.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ste
 */
public class ModuleConnection extends DBConnection {

    /**
     * Creates a connection to cis4005 database
     *
     * @param dbName String value of database name
     */
    public ModuleConnection(String dbName) {
        this.connectDatabase(dbName);
    }

    /**
     * Adds students number and module number to the StudentModule table of the
     * database
     *
     * @param studentNO Integer value for student number to help
     * @param moduleID Integer value for module code
     */
    public void AddStudentModule( int studentNO, int moduleID) {

        //creates SQL statement to insert a studentNO and moduleCode into the STUDENTMODULE table. 
        //values to be inserted are assigned to (?,?) values
        final String insertStmt = "INSERT INTO cis4005.STUDENTMODULE(StudentNO,ModuleCode) VALUES(?,?)";

        try {
            // This statement defines a Prepared statement that will insert values into the insertStmt String. 
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            // This statement sets the values of the prepared statement to the parameters passed into the brackets.  
            //These refer to the column name and number
            pstmt.setInt(1, studentNO);
            pstmt.setInt(2, moduleID);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "You have Selected an Invalid number Please Try Again" + sqle);
        } catch (Exception e) {
            System.out.println("Exception" + e.toString());
        }

    }

    /**
     * This method Inserts a Module title, Module Code and level into the MODULE
     * table and takes a parameter of Module.
     *
     * @param module parameter of module that is being inserted required to
     * supply values to be input into prepared statement.
     */
    public void insertModule(Module module)  {

        // Defines a String SQL statement to insert Module  title, Module Code and level into the MODULE table
        final String insertStmt = "INSERT INTO cis4005.MODULE(ModuleTitle, ModuleCode, Level ) VALUES(?,?,?)";
        try {
            // This statement sets the values of the prepared statement to the parameters passed into the brackets.  
            //These refer to the column name and number
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            int a = module.getCode();
            String b = Integer.toString(a);
            pstmt.setString(1, module.getTitle());
            pstmt.setString(2, b);
            pstmt.setInt(3, module.getLev());

            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Exception when inserting Module: " + sqle.toString());
        } catch (Exception e) {
            System.out.println("Exception" + e.toString());
        }

    }

    /**
     * Deletes a Module from the MODULE table based on input value of ModuleCode
     *
     * @param moduleCode parameter of module that is being deleted which is
     * required to supply values to be input into prepared statement.
     */
    public void deleteModule(String moduleCode) {

// creates an SQL statement to delete a Module based on input value of moduleCode
        final String deleteStmt = "DELETE FROM cis4005.MODULE WHERE MODULECODE = ?";

        try {
            PreparedStatement pstmt = getConnection().prepareStatement(deleteStmt);
            pstmt.setString(1, moduleCode);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Exception when deleting module record: " + sqle.toString());
        }
    }

    /**
     * Prints information of a module based on the input moduleCode
     *
     * @param moduleCode parameter of module that is being printed which is
     * required to supply values to be input into prepared statement.
     */
    public void printModuleInfo( String moduleCode) {
        // Defines a String SQL statement to print Module title, Module Code and level from the MODULE table
        final String retrieveQuery = "SELECT * from cis4005.MODULE ORDER BY MODULE CODE";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        try {
            if (null != output) {
                while (output.next()) {
                    int title = output.getInt(1);
                    int code = output.getInt(2);
                    int level = output.getInt(3);

                    System.out.println("Module Code : " + code + "\n" + "Module Title: " + title + "\n" + "Module Level: " + level);
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Exception when printing information: " + sqle.toString());
        }

    }
    
    /**
     * Deletes a Module from the MODULE table based on input value of ModuleCode
     *
     * @param studentCode prarameter of students number to be deleted
     * @param moduleCode parameter of module that is being deleted which is
     * required to supply values to be input into prepared statement.
     */
    public void deleteStudentFromModule(int studentCode, int moduleCode) {

// creates an SQL statement to delete a Module based on input value of moduleCode
        final String deleteStmt = "DELETE FROM cis4005.STUDENTMODULE WHERE STUDENTNO = ? AND MODULECODE = ? ";

        try {
            PreparedStatement pstmt = getConnection().prepareStatement(deleteStmt);
            pstmt.setInt(1, studentCode);
            
            pstmt.setInt(2,moduleCode);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Exception when deleting module record: " + sqle.toString());
        }
    }
 
    /**
     *
     * @param modCode module code
     * @param jTable1 Jtable to display results to
     */
    public void printAllStudentsInModule(int modCode, JTable jTable1) {

        try {

         
            final String retrieveQuery = "SELECT * FROM cis4005.STUDENTMODULE WHERE MODULECODE = ? ";
            this.setQuery(retrieveQuery);
            this.runQuery();

            PreparedStatement pstmt = getConnection().prepareStatement(retrieveQuery);
            pstmt.setInt(1, modCode);
            ResultSet output = pstmt.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(output));
            jTable1.setVisible(true);
            System.out.println("wwwwww");
        } catch (SQLException e) {
            System.out.println("Exception when printing all students: " + e.toString());
        }

    }
}
