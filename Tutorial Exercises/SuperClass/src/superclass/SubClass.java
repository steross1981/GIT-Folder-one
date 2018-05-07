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
public class SubClass extends SuperClass {
    
    public void println(){
        System.out.println("Sub Class");
        super.print();
    }
    
}
