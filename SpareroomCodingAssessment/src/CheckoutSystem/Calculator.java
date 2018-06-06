package CheckoutSystem;

import java.util.ArrayList;

public class Calculator {

	private int countA;
	private int countB;
	private int countC;
	private int countD;

	private int costA;
	private int costB;
	private int costC;
	private int costD;

	private int finalPrice;

	public Calculator() {
		
	}

	// method to calculate the price of the items scanned
	public void calculatePrice(ArrayList<Item> itemCodes) {
		// for loops through the array of item codes and iterates a counter based on the
		// item code;
		for (Item item : itemCodes) {

			switch (item.getCode()) {
			case 'a':
			case 'A':
				countA++;
				break;

			case 'b':
			case 'B':
				countB++;
				break;

			case 'c':
			case 'C':
				countC++;
				break;

			case 'd':
			case 'D':
				countD++;
				break;
			default:
				break;

			}

		}
		/*
		 * Calculates price for items A if statement evaluates the count. Discount  relative to 
		 * - (countA / 3) * 10
		 * is applied If the count is greater than or equal to 3 
		 */
		
		if (countA >= 3 ) {

			costA = (countA * 50) - (countA / 3) * 10;

		}

		/*
		 * Determines if count is more than 0 and less than 3 then applies normal
		 * pricing to items
		 */
		
		else if (countA > 0 && countA < 3) {
			costA = countA * 50;

		}

		/*
		 * calculates price of items B if statement evaluates the count. Discount relative to 
		 * - (countB / 2) * 10
		 * is applied If the count is greater than or equal to 2 
		 */
		
		if (countB >= 2 ) {

			costB += (countB * 35) - ((countB / 2) * 10);

			/* Determines if count is more than 0 and less than 2 then applies normal
			 * pricing to items
			 */
			
		} else if (countB > 0 && countB < 2) {
			costB += 35;
		}
		
		// calculates price of items C
		costC += countC * 25;
		// calculates price of items D
		costD += countD * 12;
		// calculates final price
		System.out.println(costA);
		finalPrice = costA + costB + costC + costD;

	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public int getCountA() {
		return countA;
	}

	public int getCountB() {
		return countB;
	}

	public int getCountC() {
		return countC;
	}

	public int getCountD() {
		return countD;
	}

}
