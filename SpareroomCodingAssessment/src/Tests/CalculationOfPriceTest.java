package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CheckoutSystem.Calculator;

class CalculationOfPriceTest {

	@Test
	void test() {
		
		
		ArrayList<Character> aList = new ArrayList<Character>();
		aList.add('a');
		aList.add('c');
		Calculator calcu = new Calculator(aList);
		calcu.calculatePrice(aList);
		
		assertEquals(75,calcu.getFinalPrice());
		
		
	}

}
