/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addandoutput;

/**
 *
 * @author ste
 */
public class AddAndOutput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int count = 0;

        for (int i = 1; i <= 10; i += 1) {
            System.out.println("We will now add all numbers up until 10");
            System.out.println("Next number: " + count);
            count = count + i;
        }
        System.out.println("The overall result is: " + count);
    }
}
