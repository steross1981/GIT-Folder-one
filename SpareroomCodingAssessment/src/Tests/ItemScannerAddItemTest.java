package Tests;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import CheckoutSystem.Item;
import CheckoutSystem.ItemScanner;

class ItemScannerAddItemTest {
	
	@Test
	void test() {
		
		
		
			
		ItemScanner scan = new ItemScanner();
		ArrayList<Item> items = new ArrayList<Item>();
	
		scan.addItems(items);
	
	System.out.println(items);
		
		
		
	assertEquals("Checking The size of list", 1,items.size());
		
		
		
	}

}
