package LinearSearch;

import java.util.Scanner;

public class LinearSearchTest {
public static void main (String[] args)
{
	Scanner input = new Scanner(System.in);
	int searchInt;// search key
	int position;// location of search key in array
	
	// create array and output it 
	LinearArray searchArray = new LinearArray(10);
	System.out.println(searchArray + "\n");
	
	System.out.print("Please enter an integer value(-1 to quit): ");
	searchInt = input.nextInt();
	
	while (searchInt != -1)
	{
		position = searchArray.linearSearch(searchInt);
		
		if (position == -1)
			System.out.println("The integer was not found.\n");
		else
			System.out.println("The integer " + searchInt + " was found in position " + position + "\n" );
	System.out.println("Please enter an integer value(-1 to quit)");
	// program will keep prompting user to enter value without this line
	searchInt = input.nextInt();
	
	}
}
	
}
