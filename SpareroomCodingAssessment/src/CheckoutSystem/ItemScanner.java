package CheckoutSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemScanner {

	private char code;
	private boolean exit = false;
	private ArrayList<Character> itemCodes;
	
	public ItemScanner()
	
	{
	
		scanItems();
	}
	
	public void addItems(Scanner in, ArrayList<Character> arrayList) {
		itemCodes = arrayList;
		System.out.println("Please enter Item code. Enter x to quit");
		code = in.next().charAt(0);
		System.out.println(code);
		arrayList.add(code);
		}	
	
	
	public void scanItems() {
	

		Scanner in = new Scanner(System.in);
		addItems(in,itemCodes);

		while (!exit) {	
		if(code != 'x') {
			switch(code)
		{
		case 'a':
			addItems(in,itemCodes);
		break;
	
		case 'b': 
			addItems(in,itemCodes);
		break;
		
		case 'c': 
			addItems(in,itemCodes);
	break;
		
		case 'd': 
	
			addItems(in,itemCodes);
	break;
		case 'x': exit = true;
		break;
		default:
			System.out.println("Please enter either a, b, c, or d.  Enter x to quit");
			code = in.next().charAt(0);
			break;
		
		}
		}else {
			System.out.println("Quit");
			break;}

		}
System.err.println(itemCodes.toString());
in.close();
		

	}
	
	public ArrayList<Character> getCodes()
	{
		return itemCodes;
	}

}