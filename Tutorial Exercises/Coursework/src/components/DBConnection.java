
package components;

/**
 *
 * @author Steven Ross 22202293
 */
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *This class creates a connection with Apache Derby Database. 
 * @author ste
 */
public class DBConnection {

    private Connection dbConnection = null;
    private Statement stmt = null;
    private ResultSet dataRS = null;
    private String query = null;
 

    /**
     * Loads the drivers org.apache.derby.jdbc.ClientDriver.class; required for connecting to the database 
     * 
     */
    private void loadDriver() {
        try {
            //defines driver
            Class driver = org.apache.derby.jdbc.ClientDriver.class;
            System.out.println("Class = " + driver.getSimpleName());
            //loads driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException error) {
            System.out.println("Can't load driver " + error.toString());
            System.exit(1);
        } catch (Exception er) {
            JOptionPane.showMessageDialog(null, er.toString());
        }
    }

    /**
     *loads database driver and connects to database  defined through the parameter dbName
     * @param dbName String value of database to be connected to 
     */
    public void connectDatabase(final String dbName) {
        try {
            loadDriver();
            // gets connection to address jdbc:derby://localhost:1527/ 
            dbConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "cis4005", "cis4005");

        }//End 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    /**Method for sending a query to the database
     *
     */
    public void runQuery() {
        try {
            
            // creates a new database statement connection and sets it to variable stmt
            stmt = dbConnection.createStatement();
            //runs the query passed into the parameter query and sets to variable dataRS
            dataRS = stmt.executeQuery(query);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
    }

    /**
     * Method of setting a database query equal to the argument passed into the parameter of String q
     * @param q parameter to be set as query
     */
    public void setQuery(final String q) {
        
        query = new String(q);
    }

    /**
     *closes the database connection
     */
    public void closeConnection() {
        try {
            // checks if database is open or closed
            if (null != dbConnection && !dbConnection.isClosed()) {
               // closes database
                dbConnection.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }

    }

    /**
     *returns ResultSet value of dataRS
     * @return returns ResultSet
     */
    public ResultSet getResultSet() {
        return dataRS;
    }

    /**
     *Returns the Database connection
     * @return returns the database connection
     */
    public Connection getConnection() {
        return dbConnection;
    }
    
    

}
