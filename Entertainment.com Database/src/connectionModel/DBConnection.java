/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionModel;

import dataModel.Entertainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DBConnection {

private Connection dbConnection = null;
private Statement statement = null;
private ResultSet resultSet = null;
private String query = null;
private String dbUser = "root";
private String dbPass = "password";
    private void loadDriver() {
        Class driver = com.mysql.jdbc.Driver.class;

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void connectDatabase(String dbName) {
        loadDriver();
        try {
            
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/",dbUser,dbPass);
            this.addCourseworkDB();
            this.addPostcode();
            this.addAddress();
            this.addCustomers();
            this.addEvent();
            this.addEntertainer();
            this.addEngagement();
            System.out.println("Connection Success");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database: "+ dbName + " Cannot be connected, please check your username and password and that MySQL server is running");
        }
    }

    public void setQuery(final String q) {
        query = q;

    }

    public void runQuery() {
    try {
        statement = dbConnection.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        resultSet = statement.executeQuery(query);
    } catch (SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }

    }

    public void closeConnection() {
        
    try {
        if( null != dbConnection && !dbConnection.isClosed())
        {
            dbConnection.close();
        }
    } catch (SQLException ex) {
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
    }

    }

    public ResultSet getResultset() {
        
        return resultSet;

    }

    public Connection getConnection() 
    {
        return dbConnection;
    }
    
    public void addCourseworkDB() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = "CREATE SCHEMA IF NOT EXISTS coursework DEFAULT CHARACTER SET utf8;";
          
            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
        
    }
        
    public void addPostcode() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = 
"CREATE TABLE IF NOT EXISTS coursework.Postcode(\n" +
"  Postcode VARCHAR(255) NOT NULL,\n" +
"  City VARCHAR(255) NOT NULL,\n" +
"  PRIMARY KEY (Postcode),\n" +
"  UNIQUE INDEX Postcode_UNIQUE (Postcode ASC))\n" +
"ENGINE = InnoDB;\n";

            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
    
}
     public void addAddress() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = 
"CREATE TABLE IF NOT EXISTS coursework.address(\n" +
"  idAddress INT(11) NOT NULL AUTO_INCREMENT,\n" +
"  HouseNumber INT NOT NULL,\n" +
"  Postcode_FK VARCHAR(255) NOT NULL,\n" +
"  PRIMARY KEY (idAddress),\n" +
"  UNIQUE INDEX idAddress_UNIQUE (idAddress ASC),\n" +
"  INDEX CityID_FK_idx (Postcode_FK ASC),\n" +
"  CONSTRAINT Postcode_FK\n" +
"    FOREIGN KEY (Postcode_FK)\n" +
"    REFERENCES coursework.Postcode (Postcode)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION)\n" +
"ENGINE = InnoDB\n" +
"DEFAULT CHARACTER SET = utf8;";

            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
    
}
    public void addCustomers() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = 

                    "CREATE TABLE IF NOT EXISTS coursework.customers (\n" +
"  idCustomer INT(11) NOT NULL AUTO_INCREMENT,\n" +
"  firstNme VARCHAR(255) NOT NULL,\n" +
"  LastNam VARCHAR(255) NOT NULL,\n" +
"  Email VARCHAR(45) NOT NULL,\n" +
"  idAddress_FK INT(11) NOT NULL,\n" +
"  PRIMARY KEY (idCustomer),\n" +
"  UNIQUE INDEX idCustomer_UNIQUE (idCustomer ASC),\n" +
"  UNIQUE INDEX Email_UNIQUE (Email ASC),\n" +
"  INDEX dd_fk_idx (idAddress_FK ASC),\n" +
"  CONSTRAINT customers_idAddress_FK\n" +
"    FOREIGN KEY (idAddress_FK)\n" +
"    REFERENCES coursework.address (idAddress)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION)\n" +
"ENGINE = InnoDB\n" +
"AUTO_INCREMENT = 2\n" +
"DEFAULT CHARACTER SET = utf8;";

            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
    
}
      public void addEvent() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = 

                    "CREATE TABLE IF NOT EXISTS coursework.event(\n" +
"  idEvent INT(11) NOT NULL AUTO_INCREMENT,\n" +
"  eventName VARCHAR(255) NOT NULL,\n" +
"  EventType VARCHAR(255) NOT NULL,\n" +
"  Date DATE NOT NULL,\n" +
"  customerCharge INT(11) NOT NULL DEFAULT '10',\n" +
"  idCustomer_FK INT(11) NULL,\n" +
"  PRIMARY KEY (idEvent),\n" +
"  UNIQUE INDEX idEvent_UNIQUE (idEvent ASC),\n" +
"  INDEX fk_idx (idCustomer_FK ASC),\n" +
"  CONSTRAINT event_idCustomer_FK\n" +
"    FOREIGN KEY (idCustomer_FK)\n" +
"    REFERENCES coursework.customers (idCustomer)\n" +
"    ON DELETE SET NULL\n" +
"    ON UPDATE NO ACTION)\n" +
"ENGINE = InnoDB\n" +
"DEFAULT CHARACTER SET = utf8;";

            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
    
}
       public void addEntertainer() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = 

                    "CREATE TABLE IF NOT EXISTS coursework.entertainers(\n" +
"  Name VARCHAR(255) NOT NULL,\n" +
"  EntType VARCHAR(255) NOT NULL,\n" +
"  Fee FLOAT NOT NULL,\n" +
"  PRIMARY KEY (Name))\n" +
"ENGINE = InnoDB\n" +
"AUTO_INCREMENT = 2\n" +
"DEFAULT CHARACTER SET = utf8;";

            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
    
}
       public void addEngagement() throws SQLException
    {
        PreparedStatement pstmt = null;
        try {
            final String insertStmt = 

                    "CREATE TABLE IF NOT EXISTS coursework.engagement (\n" +
"  idEvent_FK INT(11) NOT NULL,\n" +
"  EntertainerName_FK VARCHAR(255) NOT NULL,\n" +
"  FixedFee INT NOT NULL DEFAULT '10',\n" +
"  INDEX EventID_FK (idEvent_FK ASC),\n" +
"  INDEX engagement.EntertainerName_FK_idx (EntertainerName_FK ASC),\n" +
"  PRIMARY KEY (idEvent_FK, EntertainerName_FK),\n" +
"  CONSTRAINT engagement_idEvent_FK\n" +
"    FOREIGN KEY (idEvent_FK)\n" +
"    REFERENCES coursework.event (idEvent),\n" +
"  CONSTRAINT engagement.EntertainerName_FK\n" +
"    FOREIGN KEY (EntertainerName_FK)\n" +
"    REFERENCES coursework.entertainers (Name)\n" +
"    ON DELETE CASCADE\n" +
"    ON UPDATE NO ACTION)\n" +
"ENGINE = InnoDB\n" +
"DEFAULT CHARACTER SET = utf8;";

            pstmt = getConnection().prepareStatement(insertStmt);
          
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EntertainerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e)
        {
            System.out.println("nope");
        }finally {
            pstmt.close();
        }
    
}
}