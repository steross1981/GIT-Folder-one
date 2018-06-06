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
		
		
		Scanner in = new Scanner(System.in);

		ItemScanner scan = new ItemScanner();
		ArrayList<Character> itemCodes = new ArrayList<Character>();
		
		scan.addItems(in,itemCodes);
		
		in.close();
		
	assertEquals("Checking The size of list: ", 2,itemCodes.size());
		
		
		
	}

}
