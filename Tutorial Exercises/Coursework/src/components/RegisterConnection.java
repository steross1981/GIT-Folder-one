/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import DataModel.Register;
import DataModel.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ste
 */
public class RegisterConnection extends DBConnection {

    /**
     * This class contains methods for connecting to a database and inserting a new register
     * @param dbName name of database to connect to
     */
    public RegisterConnection(final String dbName) {
        this.connectDatabase(dbName);

    }

    /**Inserts a register into the database
     *
     * @param register register to be inserted into the database
     */
    public void insertRegister(Register register) {
        final String insertStmt = "INSERT INTO cis4005.REGISTER(WeekNO, ModuleCode,StudentNO,Attending) VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);

            pstmt.setInt(1, register.getWeek());
            pstmt.setInt(2, register.getCode());
            pstmt.setInt(3, register.getNum());
            pstmt.setInt(4, register.getAttending());
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Exception when update register: " + sqle.toString());
        }

    }

    /** prints register info to a jtable
     *
     * @param jtable jtable to display results to
     */
    public void printRegisterInfo(JTable jtable) {
        try{

// Defines a String SQL statement to print Module title, Module Code and level from the MODULE table

        final String retrieveQuery = "SELECT * from cis4005.REGISTER ORDER BY WEEKNO";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        jtable.setModel(DbUtils.resultSetToTableModel(output));
        
              
            
        } catch (Exception sqle) {
            System.out.println("Exception when printing information: " + sqle.toString());
        }

    }
}
