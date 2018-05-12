/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionModel;

import dataModel.Entertainer;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ste
 */

public class EntertainerConnection extends DBConnection {
    private int numb;
    ResultSet op;
    public EntertainerConnection(String dbName)
    {
        this.connectDatabase(dbName);
    }
    
    public void addEntertainer(Entertainer ent) throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = " INSERT INTO coursework.entertainers ( Name,  EntType, Fee) VALUES (?,?,?)";
            pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setString(1,ent.getName());
            pstmt.setString(2,ent.getEntType());
            pstmt.setInt(3,ent.getFee());
            pstmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
        
    }
     public void getAllnames(JComboBox jbx)
    {
        try {
            String query = "SELECT Name FROM coursework.Entertainers";
            
            this.setQuery(query);
            this.runQuery();
            ResultSet output = this.getResultset();
            
            while(output.next())
            {
                String v = output.getString(1);
                jbx.addItem(v);
            }} catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error getting all Entertainers Names" + ex.toString());
        }
    }
        public void countEngagements(String entName,JTable jTable2, Date date1, Date date2)
        {
            
        try {
            String query = "SELECT \n" +
"    EntertainerName_FK, Name, COUNT(Name)\n" +
"FROM\n" +
"    coursework.engagement\n" +
"        JOIN\n" +
"    coursework.entertainers ON EntertainerName_FK = Name AND Name = ?\n" +
"        JOIN\n" +
"    coursework.event ON idEvent_FK = idEvent \n" +

"GROUP BY EntertainerName_FK\n" +
"ORDER BY COUNT(*) DESC";
            PreparedStatement pot = getConnection().prepareStatement(query);
            pot.setString(1, entName);
          
            ResultSet num = pot.executeQuery();
           
               jTable2.setModel(DbUtils.resultSetToTableModel(num));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        }
        
        public void countEngagementsByDate(String entName,JTable jTable2, Date date1, Date date2)
        {
            
        try {
            String query = "SELECT \n" +
"  Date,  EntertainerName_FK, Name, COUNT(Name)\n" + 
"FROM\n" +
"    coursework.engagement\n" +
"        JOIN\n" +
"    coursework.entertainers ON EntertainerName_FK = Name AND Name = ?\n" +
"        JOIN\n" +
"    coursework.event ON idEvent_FK = idEvent AND Date BETWEEN ? AND ?  \n" +

"GROUP BY Date\n" +
"ORDER BY COUNT(*) DESC";
            PreparedStatement pot = getConnection().prepareStatement(query);
            pot.setString(1, entName);
            pot.setDate(2,date1);
            pot.setDate(3,date2);
            ResultSet um = pot.executeQuery();
           
               jTable2.setModel(DbUtils.resultSetToTableModel(um));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        }
    
    public void showPopularity(JTable jTable2, Date te1, Date te2)
    {
          
        try {
            String query = "Select Name,entType, count(EntertainerName_FK) "
                    + "AS NumberOFBookings  from coursework.engagement\n" +
                    "join coursework.Entertainers on Name = EntertainerName_FK"
                    + "  JOIN coursework.event on idEvent= idEvent_FK"
                    + " AND  Date between ? \n" +
                    "AND ?\n"+
                    "group by Name\n" +
                    "order by count(Name) desc";
            PreparedStatement pot = getConnection().prepareStatement(query);
            pot.setDate(1,te1);
            pot.setDate(2,te2);
            ResultSet nut = pot.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(nut));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showMostPopularEntertainer(JTable jTable2, Date te1, Date te2 )
    {
         try {
            String query = "SELECT Name, MAX(x.NumberOfBookings) AS NumberOfBookings FROM\n" +
"(Select Name, count(Name) AS NumberOFBookings  from coursework.entertainers\n" +
"join coursework.engagement ON Name = EntertainerName_FK\n" +
"join coursework.event where idEvent = idEvent_FK\n" +
" AND Date between ? AND ? " +
"group by Name\n" +
"order by count(*) desc) AS x";
            PreparedStatement pot = getConnection().prepareStatement(query);
            
            pot.setDate(1,te1);
            pot.setDate(2,te2);
            ResultSet nut = pot.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(nut));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void showLeastPopularEntertainer(JTable jTable2, Date te1, Date te2 )
    {
         try {
            String query = "SELECT Name, MIN(x.NumberOfBookings) AS NumberOfBookings FROM\n" +
"(Select Name, count(NAME) AS NumberOFBookings  from coursework.entertainers\n" +
"join coursework.engagement ON Name = EntertainerName_FK\n" +
"join coursework.event where idEvent = idEvent_FK\n" +
" AND Date between ? AND ? " +
"group by EventType\n" +
"order by count(*) desc) AS x";
            PreparedStatement pot = getConnection().prepareStatement(query);
            
            pot.setDate(1,te1);
            pot.setDate(2,te2);
            ResultSet nut = pot.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(nut));
            jTable2.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addEntertainerToEvent(String EvenName ,String EnterNme) throws SQLException
    {
        PreparedStatement pstmt;
        PreparedStatement pstmt2;
        try {
            System.out.println(EvenName);
            final String instertStmt = "INSERT INTO coursework.engagement(idEvent_FK, EntertainerName_FK)  VALUES((SELECT idEvent FROM coursework.event WHERE eventName = ?),?)";

            pstmt = getConnection().prepareStatement(instertStmt);
            pstmt.setString(1,EvenName);
            pstmt.setString(2,EnterNme);
  
            pstmt.execute();
 
            final String instertStmt2 =
"UPDATE coursework.event SET customerCharge = (customerCharge + (SELECT Fee FROM coursework.entertainers WHERE Name = ?) + 10) WHERE eventName = ?";
              pstmt2 = getConnection().prepareStatement(instertStmt2);

            pstmt2.setString(1,EnterNme);
            pstmt2.setString(2,EvenName);
        
            pstmt2.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entertainer is already booked onto this Event."
                    + "\nWould you like to book a different Entertainer?" );
        } catch (Exception e)
        {
            System.out.println("nope");
        }
    }
    public ResultSet checkEntertainerExist(String entName)
    {
        
        try {
            String query =  "SELECT * FROM coursework.entertainers WHERE name = ?";
            
            PreparedStatement pstmt = getConnection().prepareStatement(query);
            pstmt.setString(1, entName);
            ResultSet output = pstmt.executeQuery();
         
            
            op = output;
            
       
           
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
   return op;
    }
    
     public void showEntertainersNames(JTable jTable)
  {
      String query = "SELECT \n" +
              "   Name AS Entertainers, EntType AS EntertainmentType, Fee AS Fee From coursework.entertainers ";
            
      this.setQuery(query);
      this.runQuery();
      ResultSet output = this.getResultset();
      jTable.setModel(DbUtils.resultSetToTableModel(output));
      jTable.setVisible(true);
  }
}
