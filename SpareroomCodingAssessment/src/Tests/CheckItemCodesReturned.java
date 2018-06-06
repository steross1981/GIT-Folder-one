package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import CheckoutSystem.ItemScanner;

class CheckItemCodesReturned {

	@Test
	void test() {
	Scanner in = new Scanner(System.in);

 		ItemScanner items = new ItemScanner();
	assertEquals(Arrays.asList('a','b','c','x'), items.getCodes());	
	in.close();
	}

}
