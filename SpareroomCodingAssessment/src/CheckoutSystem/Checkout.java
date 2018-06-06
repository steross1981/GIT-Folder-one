package CheckoutSystem;

import java.util.ArrayList;

public class Checkout {

	public static void main (String[] args)
	{
		// instantiates a new ItemScanner object
		ItemScanner itemScan = new ItemScanner();
		// sets the values in an arraylist equal to that in itemScanner array
		ArrayList<Character> codes = itemScan.getCodes();
		// Instantiates a new Calculator object that calculates the price of the items in the supplied array;
		Calculator calc = new Calculator(codes);

		// getCount and getFinalPrice methods of calculator object in order to supply values in printed out info 
		int countA = calc.getCountA();
		int countB = calc.getCountB();
		int countC = calc.getCountC();
		int countD = calc.getCountD();
		int finalPrice = calc.getFinalPrice();
		
		// prints out costs and final price
		System.out.println("You have scanned " + countA + " units of item A at a price of 50 each. With a discount of " + (countA/3) * 10 );
		System.out.println("You have scanned " + countB + " units of item B at a price of 35 each. With a discount of" + (countB / 2) * 10);
		System.out.println("You have scanned " + countC + " units of item C at a price of 25 each");
		System.out.println("You have scanned " + countD + " units of item D at a price of 12 each");
		System.out.println("The Total before savings is: " + (countA * 50 + countB * 35 + countC * 25 + countD * 12));
		
		
		System.out.println("The final Price for all units is = " + finalPrice);
		
	}
}
