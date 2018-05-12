package LinearSearch;

import java.util.Arrays;
import java.util.Random;

public class LinearArray {
	
	private int[] data;
	private static final Random generator =  new Random();
	
	public LinearArray(int size) 
	{
		data = new int[size];
		for (int i =0; i < size; i++)
			data[i]= 10 + generator.nextInt(90);
	}
	
	public int linearSearch(int searchKey)
	{
		for (int index = 0; index < data.length; index++)
		if (data[index] == searchKey )
		
			return index;
		return -1;
		
			
		
	}
	
	public String toString()
	{
		return Arrays.toString(data);
	}

}
