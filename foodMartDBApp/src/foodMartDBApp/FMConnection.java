package foodMartDBApp;


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.util.Scanner;
	import java.util.logging.Level;
	import java.util.logging.Logger;

	/**
	 *
	 * @author ste
	 */
	public class FMConnection extends DBConnection {

	    public FMConnection(String dbName) {

	        this.connectDatabase(dbName);

	    }

	    public void UseDB() {

	        String query = "Use foodmart";
	        {

	            this.setQuery(query);
	            this.runQuery();

	        }
	    }

	    public void getResults(String payType, int deptID, String level) {
	        
	        //  Create Scanner for input from command window
	        
	        System.out.println("hey");
	        try {

	            String query = " SELECT department.department_id,department.department_description, employee.employee_id, employee.full_name, employee.position_title, position.management_role, employee.salary, position.pay_type,employee.education_level\n" +
	" FROM employee\n" +
	" JOIN department ON  employee.department_id =  department.department_id \n" +
	" JOIN position ON employee.position_id = position.position_id\n" +
	" WHERE position.pay_type = ? AND department.department_id = ? AND employee.education_level = ? " +
	" order by employee_id asc";
	            
	            PreparedStatement pstmt = getConnection().prepareStatement(query);
	           
	            pstmt.setString(1, payType);
	            pstmt.setInt(2, deptID);
	            pstmt.setString(3, level);
	          
	            System.out.println(pstmt.toString() + level);
	            ResultSet rSet = pstmt.executeQuery();
	            
	            ResultSetMetaData rsmd = rSet.getMetaData();

	            int columnsNumber = rsmd.getColumnCount();

	            System.out.println(columnsNumber);
	          
	          //  while (rSet.next())
	          //  {
	                //System.out.println("hey");
	                //Print one row          
	                for (int i = 1; i < columnsNumber; i++) {

	                    System.out.print(rSet.getString(i + 1) + " " + "|" + " "); //Print one element of a row

	                }
	                System.out.println();
	                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");//Move to the next line to print the next row.           

	           // }
	//
	        } catch (SQLException ex) {
	            Logger.getLogger(FMConnection.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	}

