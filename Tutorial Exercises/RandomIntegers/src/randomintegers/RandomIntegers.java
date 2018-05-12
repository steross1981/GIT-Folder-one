/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomintegers;

import java.util.Random;

/**
 *
 * @author ste
 */
public class RandomIntegers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random randomNumbers = new Random();
        
        int face; // stores each random integer generated
        
        for( int counter = 1; counter <= 20; counter++)
        {
            //pick a random int from 1 to 6
            face = 1 + randomNumbers.nextInt(6);
            
            System.out.printf("%d", face);
            
            if (counter % 5
                    == 0)
                System.out.println();
            
        }
        // TODO code application logic here
    }
    
}
