/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author ste
 */
public class Worker extends Person {
    
     private int hourlyRate;
    private int hoursWorked;
    
    
    public Worker (String workerName,String workerAddress,String workerNINumber, int workerAge, int workerPay)
    {
        super(workerName, workerAddress, workerNINumber, workerAge, workerPay);
    }
    
    
    
    public void setHourlyRate( int workerHourlyRate){
        
        hourlyRate = workerHourlyRate;
    }
    
    public void setHoursWorked( int workerHoursWorked){
        
        hoursWorked = workerHoursWorked;
        
    }
    
    public void calculateWages(){
        
        
       super.pay = hoursWorked * hourlyRate;
        
    }
    
    public void workerList(){
        
     
    }
}
