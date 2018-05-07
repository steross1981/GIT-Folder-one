
package picalculator;


import javax.swing.JOptionPane;

public class PiCalculator {

    public static String input;
    public static double radius;

    public static void main(String[] args) {
        
        CircleArea myCircleArea =  new CircleArea();
        
     input = JOptionPane.showInputDialog("Please enter radius value in metres: ");
        radius = Double.parseDouble(input);
        myCircleArea.setArea(radius);
        System.out.println("Your Area is " + myCircleArea.getArea());
        
    }
    
}
