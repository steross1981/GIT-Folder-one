package Tests;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import CheckoutSystem.ItemScanner;

class CheckItemCodesReturned {
// Tests whether the codes returnd by the getCodes method are correct
	@Test
	
	void test() {
	
// Instantiates a new ItemScanner object
 		ItemScanner items = new ItemScanner();
 		//assert checks whether the values returned are equal to what is defined
	assertEquals(Arrays.asList('a','b','c','d','x'), items.getCodes());	
	
	}

}
