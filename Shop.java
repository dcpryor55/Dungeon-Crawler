import java.util.Random;
import java.util.ArrayList;

public class Shop 
{
	public int gold;
	ArrayList<Item> items = new ArrayList<Item>();	
	public String type;
	public NPC shopKeeper;
	Random random = new Random();
	
	public void setShop()
	{
		int randNum = random.nextInt(200)+1;
		gold = randNum;
		randNum = random.nextInt(10)+5;		
		shopKeeper.setName("Grimothy");
		
		for(int i = 0; i < randNum; i++)
		{
			randNum = random.nextInt(2)+1;
			if(randNum == 1)
			{
				type = "Weapon";
				randNum = random.nextInt(4)+1;
				Item thisItem = new Item("weapon");
				switch(randNum)
				{
				case 1:				
					thisItem.weapon("shortsword");
					items.add(thisItem);
				case 2:				
					thisItem.weapon("mace");
					items.add(thisItem);
				case 3:				
					thisItem.weapon("dagger");
					items.add(thisItem);
				case 4:				
					thisItem.weapon("messer");
					items.add(thisItem);
				}
			}
			else
			{
				type = "Armor";
				randNum = random.nextInt(4)+1;
				Item thisItem = new Item("armor");
				switch(randNum)
				{
				case 1:				
					thisItem.weapon("mail");
					items.add(thisItem);
				case 2:				
					thisItem.weapon("leather");
					items.add(thisItem);
				case 3:				
					thisItem.weapon("robes");
					items.add(thisItem);
				case 4:				
					thisItem.weapon("plate");
					items.add(thisItem);
				}
			}
		}		
	}
	
	public void displayMenu()
	{
		System.out.println("--------------------- Welcome to "+shopKeeper.getName()+"'s the "+type+"! ---------------------\n");
		System.out.println("For sale: \n");
		for (int i = 0; i < items.size(); i++)
		{
			System.out.println(i+1 + ") " + items.get(i) + "\t- " + items.get(i).price + "g");
		}
		
		System.out.println("\n");
	}
}
