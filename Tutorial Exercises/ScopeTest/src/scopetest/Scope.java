/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopetest;

/**
 *
 * @author ste
 */
public class Scope {

   // field that is accesible to all methods of this class 
    private int x = 1;
    
    //method begin creates and initializes local variable x
    //and calls methods useLocalVariable and useField
    public void begin()
    {
        int x = 5;//methods local variable x shadow field x
        System.out.printf("local x in method begin is %d\n", x);
        
        useLocalVariable(); // useLocalVariable has local x 
        useField(); //useField uses class Scopes field x
        useLocalVariable(); //useLocalVariable reinitialises local x
        useField(); //class scope field x retains its value

System.out.printf("\nlocal x in method beginning is %d\n", x);
        
    }// end method begin
   
   //create and initialise local variable x during each call
    public void useLocalVariable()
    {
        int x = 25; //initialised each ttime a local variable is called
        
        System.out.printf("\nlocal x on entering method useLocalVariable is %d\n", x);
        ++x;//modifies this methods local variable
        System.out.printf("local variable x before exiting method useLocalVariable is %d\n", x);
    }// end method useLocalVariable
    
    //modify class scopes field x during each call
    public void useField()
    {
        System.out.printf("\nfield x on entering method useField is %d\n",x);
        x*=10;//modifies class scopes field x
    }
}
