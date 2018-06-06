package foodMartDBApp;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

	/**
	 *
	 * @author ste
	 */
	public class DBConnection {
	    
	    
	private Connection dbConnection = null;

	private Statement statement = null;

	private ResultSet resultSet = null;

	private String query = null;
	private String dbUser = "root";
	private String dbPass = "ROSS";



	    private void loadDriver() {
	        Class<Driver> driver = com.mysql.jdbc.Driver.class;

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
}
