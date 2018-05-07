/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output;

import javax.swing.JOptionPane;

public class Output {

    public static void main(String[] args) {

        int number;
        int number2;
        int calculation;
        String input;

        input = JOptionPane.showInputDialog("Enter number: ");
        number = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Enter number2: ");
        number2 = Integer.parseInt(input);
        calculation = number + number2;

        System.out.println("The number you entered is: " + calculation);

        System.exit(0);
    }

}
