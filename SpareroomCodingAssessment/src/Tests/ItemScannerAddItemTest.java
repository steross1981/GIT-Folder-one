package Tests;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import CheckoutSystem.ItemScanner;

class ItemScannerAddItemTest {
	ArrayList<Character> itemCodes;
	@Test
	void test() {
		
		
		
		Scanner in = new Scanner(System.in);
		
		ItemScanner scan = new ItemScanner();
		
		scan.addItems(itemCodes);
	//	System.out.println(itemCodes);
		
		
		
	assertEquals("Checking The size of list", 2,itemCodes.size());
		
		
		
	}

}
