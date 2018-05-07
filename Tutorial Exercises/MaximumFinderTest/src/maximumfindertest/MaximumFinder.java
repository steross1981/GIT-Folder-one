/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumfindertest;
import java.util.Scanner;
/**
 *
 * @author ste
 */
public class MaximumFinder {
    
    public void determineMaximum(){
        // Create Scanner for input from command window    
        Scanner input = new Scanner(System.in);                                                                                                                                                                                                                                                                 
    
        //Prompt for and input three floating-point values 
        System.out.print(
        "Enter three floating-pont values seperated by spaces");
        double number1 = input.nextDouble();// Read first double
        double number2 = input.nextDouble();// Read second double
        double number3 = input.nextDouble();// Read third double
        
        // Determine maximum value
        double result = maximum(number1, number2, number3);
        
        // Display maximum value
        System.out.println("Maximum is: " + result);
    }
        public double maximum( double x, double y, double z){
            
            double maximumValue = x; 
            
            if( y > maximumValue)
                maximumValue = y;
            
            if ( z > maximumValue)
                maximumValue = z;
            
            return maximumValue;
        }
}
    

        
