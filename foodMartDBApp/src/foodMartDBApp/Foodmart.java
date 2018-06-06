package foodMartDBApp;

import java.util.Scanner;

public class Foodmart {
	   public static void main(String[] args) {
		   
		   Scanner input = new Scanner(System.in).useDelimiter("\\n");;

	        System.out.print(
	                "Please enter the pay type you wish to query: ");
	        String payType = input.next();// Read employees pay type

	        //Prompt for and input three values
	        System.out.print(
	                "Please enter the department_id you wish to query: ");
	        int deptID = input.nextInt();// Read employees department ID

	        System.out.print(
	                "Please enter the education level you wish to query: ");
	        String level = input.next();// Read level
	        
	        FMConnection fm = new FMConnection("foodmart");
	        fm.UseDB();
	        fm.getResults(payType,deptID,level);
	    }
	    
}
