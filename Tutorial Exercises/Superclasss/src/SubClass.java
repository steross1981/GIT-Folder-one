/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ste
 */
public class SubClass extends SuperClass {
    
    public void print()
    {
        System.out.println("Sub Class");
        super.print();
    }
    
    public static void main(String[] args)
    {
        SubClass sub = new SubClass();
        sub.print();
    }
}
