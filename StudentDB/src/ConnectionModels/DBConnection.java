package ConnectionModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	  //fields
	  
    private Connection dbConnection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String query = null;
    

    //Load driver
    
    private void loadDriver()
    {
        try{
       Class driver = com.mysql.jdbc.Driver.class;
           System.out.println("Class = " + driver.getSimpleName());
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                System.out.println("yey");
            } catch (InstantiationException ex) {
                System.out.println("gewy"); Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(ClassNotFoundException error){
            System.out.println("could not load driver " + error.toString());
        }
    }

            
    
    
    
    
    //connect to database
    public void connectDatabase(final String dbName)
    {
        try{
            loadDriver();
            dbConnection = DriverManager.getConnection("jdbc:mysql://localHost:3306/studentdb?zeroDateTimeBehavior=convertToNull"  , "ROSS", "ROSS");
            
        }catch(SQLException sqle){
            System.out.println("Could not connect to Database" + sqle.toString());
        }
    }
    
    
    
    
    // execute query
    
    public void setQuery(final String q)
    {
        query = new String(q);
    }
    
    public void runQuery(){
        
        try{
        //Create a statement object 
        statement = dbConnection.createStatement();
        //Executa an SQL statement that will return a result set
        resultSet = statement.executeQuery(query);
    }catch(SQLException sqle){
        
            System.out.println("Error with method runQuery Cannot connect to database" + sqle.toString());
    }
    }
    
        public void closeConnection()
        {
            try{
                if (null != dbConnection && !dbConnection.isClosed())
                {
                    dbConnection.close();
                }
            }catch(SQLException sqle){
                System.out.println("error closing connection" + sqle.toString());
            }
        }
        
        public ResultSet getResultSet()
        {
            return resultSet;
        }
        
        public Connection getConnection()
        {
            return dbConnection;
        }
    
}
