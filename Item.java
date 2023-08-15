
public class Item 
{
	public String name;
	public String type;
	public int price;
	public int armor;
	public int damage;

	public Item(String type)
	{
		type = this.type;
	}

	public void weapon(String type)
	{				
		switch(type)
		{
		case "shortsword":
			damage = 3;
			name = "Shortsword";
			price = 25;
		case "mace":
			damage = 4;
			name = "Mace";
			price = 35;
		case "dagger":
			damage = 2;
			name = "Dagger";
			price = 15;
		case "messer":
			damage = 5;
			name = "Messer";
			price = 50;
		}		
	}
	
	public void armor(String type)
	{		
		switch(type)
		{
		case "mail":
			armor = 3;
			name = "Chain-mail";
			price = 25;
		case "leather":
			armor = 4;
			name = "Leather armor";
			price = 35;
		case "robes":
			armor = 2;
			name = "Robes";
			price = 15;
		case "plate":
			armor = 5;
			name = "Plate armor";
			price = 50;
		}		
	}
	
}
