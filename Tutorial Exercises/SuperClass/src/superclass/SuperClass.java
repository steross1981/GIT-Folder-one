/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superclass;

/**
 *
 * @author ste
 */
public class SuperClass {

 
       
     public void print(){
        System.out.println("Super Class");
    }
        public static void main(String[] args){ 
            
            SubClass mySC = new SubClass();
            mySC.println();
    }
    
}
