/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebooktest;

/**
 *
 * @author ste
 */
public class GradeBookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] gradesArray = {87, 68,94,10, 83, 78, 85, 91, 76, 87};
                GradeBook myGradeBook = new GradeBook("Vickys Maths Students",gradesArray);
                myGradeBook.displayMessage();
                myGradeBook.processGrades();
    }
    
}
