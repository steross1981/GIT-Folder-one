package CheckoutSystem;

import java.util.ArrayList;

public class Checkout {

	public static void main (String[] args)
	{
		
		ItemScanner itemScan = new ItemScanner();
		ArrayList<Character> codes = itemScan.getCodes();
		System.err.println(codes.toString());
		Calculator calc = new Calculator(codes);

		int countA = calc.getCountA();
		int countB = calc.getCountB();
		int countC = calc.getCountC();
		int countD = calc.getCountD();
		int finalPrice = calc.getFinalPrice();
		
		System.out.println("You have scanned " + countA + " units of item A at a price of " + 50 + " each. With a discount of " + (countA/3) * 10 );
		System.out.println("You have scanned " + countB + " units of item B at a price of ");
		System.out.println("You have scanned " + countC + " units of item C");
		System.out.println("You have scanned " + countD + " units of item D");
		System.out.println("The subtotal is: " + (countA * 50 + countB * 35 + countC * 25 + countD * 12));
		
		
		System.out.println("The final Price for all units is = " + finalPrice);
		
	}
}
