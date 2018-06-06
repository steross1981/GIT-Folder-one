package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import CheckoutSystem.ItemScanner;

class ItemScannerAddItemTest {

	@Test
	void test() {
		
		ArrayList<Character> itemCodes = new ArrayList<Character>();
		
		Scanner in = new Scanner(System.in);
		ItemScanner scan = new ItemScanner();
		scan.addItems(in,itemCodes);
		System.out.println(itemCodes.size());
		
	assertEquals("Checking The size of list: ", 1,itemCodes.size());
		
		
		
	}

}
