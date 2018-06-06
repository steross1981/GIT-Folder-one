package CheckoutSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemScanner {
//char variable to store the value of the item code to be added to array
	private char code;
	
	// boolean used to control the while loop
	private boolean exit = false;
	// arraylist to store item codes
	private ArrayList<Character> itemCodes = new ArrayList<Character>();
	//constructor
	private Scanner input = new Scanner(System.in);
	public ItemScanner()
	{
		// call scanItems when a new ItemScanner is create
		scanItems();
		Calculator calc = new Calculator(itemCodes);
		
	}
	
	/* This code was called repeatedly so I made it a method to add Items to an arraylist via user input of values
	 * Takes parameters of Scanner to input values and Arraylist to store the values
	 * */
	
	public void addItems(ArrayList<Character> arrayList) {
		try {
		itemCodes = arrayList;
		System.out.println("Please enter Item code. Enter x to quit");
		// sets the next input character to character variable - code.
		code = input.next().charAt(0);
		System.out.println(code);
		// adds the input character to the arraylist
		arrayList.add(code);
		}catch(Exception e)
	{
			System.out.println(e.toString());
	}
	
	}
	public void scanItems() {
	
	
		// calls the add items method to prompt the user for input and add character to array
		addItems(itemCodes);

		// while loop checks that a boolean is false then loops until it is true;
		while (!exit) {	
		// switch evaluates input value for code then for each case that evaluates true it adds the character to the array itemCodes
			switch(code)
		{
		case 'a':
			addItems(itemCodes);
		break;
	
		case 'b': 
			addItems(itemCodes);
		break;
		
		case 'c': 
			addItems(itemCodes);
	break;
		
		case 'd': 
	
			addItems(itemCodes);
	break;
	// case x sets exit to true and stops the while loop from continuing;
		case 'x': exit = true;
		input.close();
		break;
		default:
			// if the user inputs in a wrong value this case prompts them for a correct value
			System.out.println("Please enter either a, b, c, or d.  Enter x to quit");
			code = input.next().charAt(0);
			break;
				}
				}

		

	}
	
	public ArrayList<Character> getCodes()
	{
		return itemCodes;
	}

}