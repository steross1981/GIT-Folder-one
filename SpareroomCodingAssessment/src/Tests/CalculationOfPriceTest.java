package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CheckoutSystem.Calculator;
import CheckoutSystem.Item;

class CalculationOfPriceTest {
/* tests the calculatePrice method in the Calculator class, ensures the values returned are correct
 *and that the discount is applied correctly
 */
	@Test
	void test() {
		
		Item i1 = new Item();
		Item i2 = new Item();
		Item i3 = new Item();
		//creates an arraylist and populates it with item Codes
		ArrayList<Item> aList = new ArrayList<Item>();
	aList.add(i1);
	aList.add(i2);
	aList.add(i3);
		for (Item item: aList)
		{
			item.setCode('a');
			System.out.println(item.getCode());
		}
		
		Calculator calcu = new Calculator();
		//ArrayList is passed into calculatePrice method
		calcu.calculatePrice(aList);
		//assert tests whether the value gained is equal to what is expected
		assertEquals(140,calcu.getFinalPrice());
		
		
	}

}
