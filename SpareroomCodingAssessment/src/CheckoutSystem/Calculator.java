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
	private ArrayList<Character> itemCodes;

	public Calculator(ArrayList<Character> codes) {
		itemCodes = codes;

	}
	

	public void calculatePrice() {

		for (char item : itemCodes) {

			switch (item) {
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
				default: break;

			}

		}

		if (countA >= 3) {

			costA = ((countA * 50) - (countA / 3) * 10);

		}

		else if (countA > 3) {
			costA = (countA * 50) - countA;

		}

		else if (countA > 0 && countA < 3) {
			costA = countA * 50;

		}

		if (countB >= 2 && countB % 2 == 0) {

			costB += (countB * 35) - ((countB / 2) * 10);

		} else if (countB > 2) {
			costB += ((countB * 35) - (countB / 2) * 10);
		} else if (countB > 0 && countB < 2) {
			costB += 35;
		}

		costC += countC * 25;
		costD += countD * 12;

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
