/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodymassindex;

import static java.lang.Math.pow;
import javax.swing.JOptionPane;

/**
 *
 * @author ste
 */
public class BodyMassIndex {

    public static void main(String[] args) {
        String heightInput;
        String weightInput;
        double height;
        double weight;
        double bodyMassIndex;

        heightInput = JOptionPane.showInputDialog("Please enter your height in metres: ");
        height = Double.parseDouble(heightInput);
        weightInput = JOptionPane.showInputDialog("Please enter your weight in kg: ");
        weight = Double.parseDouble(weightInput);

        bodyMassIndex = weight / pow(height, height);

        if (bodyMassIndex < 18.5) {
            JOptionPane.showMessageDialog(null, "Your Body Mass Index is: " + bodyMassIndex + "\nYou are underweight");
        } else if (bodyMassIndex >= 18.5 && bodyMassIndex <= 24.9) {
            JOptionPane.showMessageDialog(null, "Your Body Mass Index is: " + bodyMassIndex + "\nYou have a normal BMI");
        } else if (bodyMassIndex >= 25 && bodyMassIndex <= 29.9) {
            JOptionPane.showMessageDialog(null, "Your Body Mass Index is: " + bodyMassIndex + "\nYou are overweight");
        } else if (bodyMassIndex > 30) {
            JOptionPane.showMessageDialog(null, "Your Body Mass Index is: " + bodyMassIndex + "\nYou are obese");
        }

    }

}
