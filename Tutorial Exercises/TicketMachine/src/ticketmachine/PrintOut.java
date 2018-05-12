package ticketmachine;

import javax.swing.JOptionPane;

public class PrintOut {

    public static String input;
    public static int moneyEntered;

    public static void main(String[] args) {

        TicketMachine myMachine = new TicketMachine(100);

        myMachine.setPrice(500);

        while (true) {

            if (myMachine.getBalance() < myMachine.getPrice()) {
                input = JOptionPane.showInputDialog("Enter Money: ");
                System.out.println("The price is: " + myMachine.getPrice());
                System.out.println("The balance is: " + myMachine.getBalance());

                moneyEntered = Integer.parseInt(input);

                myMachine.insertMoney(moneyEntered);

                System.out.println("The balance is: " + myMachine.getBalance());
            }
            if (myMachine.getBalance() >= myMachine.getPrice()) {

                myMachine.printTicket();

                break;
            }

        }

    }

}
