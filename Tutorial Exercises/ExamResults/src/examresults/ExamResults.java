/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examresults;

import javax.swing.JOptionPane;

/**
 *
 * @author ste
 */
public class ExamResults {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double courseworkGrade;
        double examGrade;
        double overallGrade;
        String courseworkInput;
        String examInput;
        double courseworkWeighting = 40;
        double examWeighting = 60;

        courseworkInput = JOptionPane.showInputDialog("Please enter your coursework grade: ");
        courseworkGrade = Integer.parseInt(courseworkInput);
        examInput = JOptionPane.showInputDialog("Please enter your exam grade: ");
        examGrade = Integer.parseInt(examInput);

        overallGrade = ((courseworkGrade * courseworkWeighting) + (examGrade * (100 - courseworkWeighting))) / 100;
        System.out.print(overallGrade);

        if (overallGrade >= 70) {
            JOptionPane.showMessageDialog(null, "Your Grade is:  " + overallGrade + "\nYour classification is distinction", "Results", JOptionPane.PLAIN_MESSAGE);
        } else if (overallGrade < 70 && overallGrade >= 60) {
            JOptionPane.showMessageDialog(null, "Your Grade is:  " + overallGrade + "\nYour classification is merit", "Results", JOptionPane.PLAIN_MESSAGE);
        } else if (overallGrade < 60 && overallGrade >= 40) {
            JOptionPane.showMessageDialog(null, "Your Grade is:  " + overallGrade + "\nYour classification is pass", "Results", JOptionPane.PLAIN_MESSAGE);
        } else if (overallGrade < 40) {
            JOptionPane.showMessageDialog(null, "Your Grade is:  " + overallGrade + "\nYou have failed", "Results", JOptionPane.PLAIN_MESSAGE);
        }

    }
}
