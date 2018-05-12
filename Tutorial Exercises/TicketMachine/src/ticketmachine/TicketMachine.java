package ticketmachine;

public class TicketMachine {

    private int price;
    private int change;
    private int balance;

    public TicketMachine(int ticketCost) {

        price = ticketCost;
        balance = 0;
        change = 0;
    }

    public int getPrice() {
        return price;
    }

    public int setPrice(int amount) {

        return price = amount;

    }

    public int getBalance() {
        return balance;
    }

    public void insertMoney(int amount) {
        balance += amount;
    }

    public void printTicket() {

        // Simulate the printing of a ticket.
        System.out.println("################");
        System.out.println("# Your Ticket");
        System.out.println("# " + price + "pounds.");
        System.out.println("################");
        System.out.println("Your Change: " + (balance - price) + "pounds");
        System.out.println();
        System.out.println();
        balance = 0;
        System.out.print("Balance: " + balance + "pounds.");
        System.out.println();
        // Update the total collected with the balance 
        ;

    }

}
