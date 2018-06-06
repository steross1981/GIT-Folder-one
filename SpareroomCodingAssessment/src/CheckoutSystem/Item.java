package CheckoutSystem;

public class Item {
	
protected char code;
protected int price;

public Item()
{
	
}
	


public void setCode(char itemCode)
{
	code = itemCode;
}

public char getCode()
{
	return code;
}

public void setPrice(int itemPrice)
{
	price = itemPrice;
}

public int getPrice(char code)
{switch (code)
	{
case 'a': price = 50;
break;
case 'b': price = 35;
break;
case 'c': price = 25;
break;
case 'd': price = 15;
break;
	}
	return price;
}
}
