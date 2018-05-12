 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crapstest;

import java.util.Random;

/**
 *
 * @author ste
 */
public class Craps {
    //create new random number generator for use in method rollDice   
    private static final Random randomNumbers = new Random(); 
      
    // enumeration with constants that represent the game status
    private enum Status { CONTINUE, WON, LOST};
    
    // constants that represent common rolls of the dice 
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    
    //plays one game off craps 
          public void play()
          {
              int myPoint = 0;
              Status gameStatus; //Can contain Continue, won or lost
              int sumOfDice = rollDice(); //  first roll of the dice
              
              switch (sumOfDice)
              {
                  case SEVEN:
                  case YO_LEVEN:
                      gameStatus = Status.WON;
                      break;
                  case SNAKE_EYES:
                  case TREY:
                  case BOX_CARS:
                      gameStatus = Status.LOST;
                      break;
                  default:
                      gameStatus = Status.CONTINUE;
                      myPoint = sumOfDice;
                      System.out.printf( "Point is %d\n", myPoint);
                      break;
              }   
               
              while (gameStatus == Status.CONTINUE)
              {
              sumOfDice = rollDice();//roll dice again
              
              ////determine game status
              
              if(sumOfDice == myPoint)
                  gameStatus = Status.WON;
              else
                  if(sumOfDice == SEVEN)
                      gameStatus = Status.LOST;
              }// end while
              
              //display won or lost message 
              if(gameStatus == Status.WON)
              System.out.println("Player wins");
              else 
                  System.out.println("Player loses");
              
              }// end method play
                      
                  public int rollDice()
                          {
                              int die1 = 1 + randomNumbers.nextInt(6);// first die roll    
                              int die2 = 1 + randomNumbers.nextInt (6);//second die roll
                              
                              int sum = die1 + die2;//sum of die values
                              
                              //display results of roll
                              System.out.printf("Player rolled  %d + %d = %d\n",
                                      die1, die2, sum);
return sum;
                          }
}

