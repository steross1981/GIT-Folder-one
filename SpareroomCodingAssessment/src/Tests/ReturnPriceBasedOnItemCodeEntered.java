package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CheckoutSystem.Item;

class ReturnPriceBasedOnItemCodeEntered {

	@Test
	void test() {
	
		
		Item item = new Item();
	//	assertEquals(50,item.getPrice('a'));
		///assertEquals(35,item.getPrice('b'));
		//assertEquals(25,item.getPrice('c'));
		//assertEquals(12,item.getPrice('d'));
		assertEquals(0, item.getPrice('f'));
	}

}
