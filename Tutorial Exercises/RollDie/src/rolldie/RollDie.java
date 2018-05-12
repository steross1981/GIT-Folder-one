/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rolldie;

import java.util.Random;

/**
 *
 * @author ste
 */
public class RollDie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random randomNumbers = new Random();
        // TODO code application logic here
        
        int frequency1 = 0; //Maintain count of 1s
        int frequency2 = 0; // Maintain count of 2s
        int frequency3 = 0; // Maintain count of 3s
        int frequency4 = 0; // Maintain count of 4s
        int frequency5 = 0; // Maintain count of 5s
        int frequency6 = 0; //Maintain count of 6s
        
        int face;
        
        for(int roll = 1; roll<= 6000; roll++)
        {
       face = 1 + randomNumbers.nextInt(6); // stores most recent value
        
        //tallys counts for 6000 rolls of die
        switch (face)
        {
                case 1:
                ++frequency1;
                break;
                
                case 2:
                ++frequency2;
                break;
                
                case 3:
                ++frequency3;
                break;
                
                case 4:
                ++frequency4;
                break;
                
                case 5:
                ++frequency5;
                break;
                
                case 6:
                ++frequency6;
                break;
        }
        
        }
    
    System.out.println("Face\tFrequency");
    System.out.printf("1\t%d\n2\t%d\n3\t%d\n4\t%d\n5\t%d\n6\t%d\n", 
            frequency1, frequency2, frequency3,frequency4,
            frequency5,frequency6);
    }
    

}