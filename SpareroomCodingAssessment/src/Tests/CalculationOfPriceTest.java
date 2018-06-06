package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CheckoutSystem.Calculator;

class CalculationOfPriceTest {
// tests the calculatePrice method in the Calculator class, ensures the values returned are correct
	@Test
	void test() {
		
		//creates an arraylist and populates it with item Codes
		ArrayList<Character> aList = new ArrayList<Character>();
		aList.add('a');
		aList.add('c');
		Calculator calcu = new Calculator(aList);
		//ArrayList is passed into calculatePrice method
		calcu.calculatePrice(aList);
		// assert tests whether the value gained is equal to what is expected
		assertEquals(75,calcu.getFinalPrice());
		
		
	}

}
