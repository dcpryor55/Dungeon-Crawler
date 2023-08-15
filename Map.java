import java.util.Random;
import java.util.ArrayList;

public class Map 
{
	private Player player;
	public char[][] map;
	public AI ai = new AI();
	public int dungeonLevel;
	private ArrayList<NPC> mobs = new ArrayList<NPC>();			
	private boolean blocked = false;
	private boolean mob = false;	
	public boolean start = false;
	public int action = 0;
	public int posX;
	public int posY;		
	private int enemyHealth = 5;
	private String chatMsg = "";
	private String chatMsg1 = "";
	private String chatMsg2 = "";
	private String chatMsg3 = "";	
	public int lastNum;
	public int randNum;
	private int counter = -1;	
	private char newValue;
	private char oldValue;
	private String check;
	boolean gameOver = false;
	boolean quit = false;

	public Map(char [][] map, Player player, int dungeonLevel)
	{
		this.map = map;
		this.player = player;
		this.dungeonLevel = dungeonLevel;
	}

	public void printMap()
	{	
		Random random = new Random();
		randNum = random.nextInt(4)+1;			
		while(lastNum == randNum)
		{				
			randNum = random.nextInt(4)+1;
		}

		System.out.println(player.getName() + "\nXL: " + player.getLevel() + "    G: " + player.getGold() + "\nHP: " + player.getHealth() + "\n");

		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{				
				if(map[i][j] == '@')
				{
					player.move(i, j);					
					map[i][j] = '.';											
				}							
				if(map[i][j] == 'O')
				{
					counter++;
					mobs.add(new NPC());
					mobs.get(counter).move(i,j);
					mobs.get(counter).setGold(randNum);
					//System.out.println("\n\ncounter: "+counter+"\t npc gold: "+mobs.get(counter).getGold());					
					ai.followPlayer(map, player, mobs.get(counter));
					chatMsg1 = "An enemy is nearby.";
				}
				if((i == player.getX()) && (j == player.getY()))
				{
					System.out.print('@' + " ");
				}				
				else	
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		int j = 4;
		int index;
		if(player.log.size() < 4)		
		{		
			for(int i = 0; i < player.log.size(); i++)
			{				
				System.out.println(player.log.get(i));			
			}
		}
		else
		{
			for(int i = 0; i < 4; i++)
			{		
				index = player.log.size() - j;
				System.out.println(player.log.get(index));
				j--;
			}
		}

		if(start == false)
		{
			System.out.println("You delve into the dungeon...");
			System.out.println(chatMsg1);
		}

		if(mob == true)
		{
			switch(randNum)
			{
			case 1:
				System.out.print("You hit the mob dealing " + player.getDamage() + " damage!\n" + chatMsg);
				player.log.add("You hit the mob dealing " + player.getDamage() + " damage!");
				if((chatMsg.equals("")) != true)
					player.log.add(chatMsg);
				break;
			case 2:
				System.out.print("You bonk the monster doing " + player.getDamage() + " damage!\n" + chatMsg);
				player.log.add("You bonk the monster doing " + player.getDamage() + " damage!");
				if((chatMsg.equals("")) != true)
					player.log.add(chatMsg);
				break;
			case 3:
				System.out.print("You slash the na'er-do-well inflicting " + player.getDamage() + " damage!\n" + chatMsg);
				player.log.add("You slash the na'er-do-well inflicting " + player.getDamage() + " damage!");
				if((chatMsg.equals("")) != true)
					player.log.add(chatMsg);
				break;
			case 4:
				System.out.print("You strike the mob dealing " + player.getDamage() + " damage!\n" + chatMsg);		
				player.log.add("You strike the mob dealing " + player.getDamage() + " damage!");
				if((chatMsg.equals("")) != true)
					player.log.add(chatMsg);
				break;
			}
		}

		if(blocked == true && mob == false)
		{
			switch(randNum)
			{
			case 1:
				System.out.println("Ouch.");
				player.log.add("Ouch.");
				break;
			case 2:
				System.out.println("*bonk*");
				player.log.add("*bonk*");
				break;
			case 3:
				System.out.println("Ow.");
				player.log.add("Ow.");
				break;
			case 4:
				System.out.println("Oops..");	
				player.log.add("Oops..");
				break;
			}
		}
		System.out.print(chatMsg2);
		if((chatMsg2.equals("")) != true)
			player.log.add(chatMsg2);
		if (action == 1)
		{
			System.out.print(chatMsg3);
			if((chatMsg3.equals("")) != true)
				player.log.add(chatMsg3);
		}
	}

	public void updateMap(String input)
	{
		Random random = new Random();
		randNum = random.nextInt(4)+1;
		posX = player.getX();
		posY = player.getY();		

		switch(input)
		{
		case "w":		
			player.moveUp();				
			break;		
		case "a":
			player.moveLeft();			
			break;		
		case "s":
			player.moveDown();			
			break;		
		case "d":
			player.moveRight();			
			break;
		case "q":
			player.moveUpLeft();
			break;
		case "e":
			player.moveUpRight();
			break;
		case "z":
			player.moveDownLeft();
			break;
		case "c":
			player.moveDownRight();
			break;
		case "C":								
			oldValue = '-';
			newValue = '+';
			if(checkAdjacent() == 1)
			{
				setAdjacent(check);
			}
			else if(checkAdjacent() > 1)
			{
				chatMsg3 = "Close which door?";
				action = 1;
			}			
			break;
		case "X":
			quit = true;
			break;
		case "G":
			gameOver = true;
			break;
		case "L":
			action = 2;
			break;
		case ">":
			if(map[player.getX()][player.getY()] == '>')
				action = 3;
			else
				chatMsg3 = "You cannot descend here.";
			break;
		case "<":
			if(map[player.getX()][player.getY()] == '<')
				action = 4;
			else
				chatMsg3 = "You cannot ascend here.";
			break;
		}

		if((map[player.getX()][player.getY()] == 'X') && mobs.get(counter).looted == false)
		{
			player.gold += mobs.get(counter).getGold();
			chatMsg2 = "You loot the corpse for " + mobs.get(counter).getGold() + " gold.";
			mobs.get(counter).looted = true;
		}
		else
			chatMsg2 = "";

		if(map[player.getX()][player.getY()] == '#') //check if the new tile is blocked or not
		{			
			blocked = true;
			mob = false;
			player.move(posX, posY);
		}
		else if(map[player.getX()][player.getY()] == 'O')
		{	
			enemyHealth = player.attack(enemyHealth, player.getDamage());				
			blocked = true;
			mob = true; 			

			if(enemyHealth <= 0)
			{
				map[player.getX()][player.getY()] = 'X';
				chatMsg = "Your foe is slain!";
			}
			else if((enemyHealth == 1) || (enemyHealth == 2))
			{
				chatMsg = "Your foe is grievously wounded";
			}	
			player.move(posX, posY);
		}
		else if(map[player.getX()][player.getY()] == '+')
		{			
			mob = false;
			map[player.getX()][player.getY()] = '-';
			player.move(posX, posY);
		}		
		else
		{
			blocked = false;
			mob = false;
		}							
	}

	public int checkAdjacent()
	{		
		int counter1 = 0;
		if(map[player.getX()][player.getY()-1] == oldValue) //check Left
		{
			counter1++;
			check = "a";
		}

		if(map[player.getX()][player.getY()+1] == oldValue) //check Right
		{
			counter1++;
			check = "d";
		}

		if(map[player.getX()-1][player.getY()] == oldValue) //check Up
		{
			counter1++;
			check = "w";
		}

		if(map[player.getX()+1][player.getY()] == oldValue) //check Down
		{
			counter1++;
			check = "s";
		}

		if(map[player.getX()-1][player.getY()-1] == oldValue) //check UpLeft
		{
			counter1++;
			check = "q";
		}

		if(map[player.getX()-1][player.getY()+1] == oldValue) //check UpRight
		{
			counter1++;
			check = "e";
		}

		if(map[player.getX()+1][player.getY()-1] == oldValue) //check DownLeft
		{
			counter1++;
			check = "z";
		}

		if(map[player.getX()+1][player.getY()+1] == oldValue) //check DownRight
		{
			counter1++;
			check = "c";
		}		
		return counter1;
	}

	public void setAdjacent(String input)
	{				
		if(map[player.getX()][player.getY()-1] == oldValue && input.equals("a")) //Left
			map[player.getX()][player.getY()-1] = newValue;			

		if(map[player.getX()][player.getY()+1] == oldValue && input.equals("d")) //Right
			map[player.getX()][player.getY()+1] = newValue;			

		if(map[player.getX()-1][player.getY()] == oldValue && input.equals("w")) //Up
			map[player.getX()-1][player.getY()] = newValue;			

		if(map[player.getX()+1][player.getY()] == oldValue && input.equals("s")) //Down
			map[player.getX()+1][player.getY()] = newValue;			

		if(map[player.getX()-1][player.getY()-1] == oldValue && input.equals("q")) //UpLeft
			map[player.getX()-1][player.getY()-1] = newValue;			

		if(map[player.getX()-1][player.getY()+1] == oldValue && input.equals("e")) //UpRight
			map[player.getX()-1][player.getY()+1] = newValue;			

		if(map[player.getX()+1][player.getY()-1] == oldValue && input.equals("z")) //DownLeft
			map[player.getX()+1][player.getY()-1] = newValue;			

		if(map[player.getX()+1][player.getY()+1] == oldValue && input.equals("c")) //DownRight
			map[player.getX()+1][player.getY()+1] = newValue;										
	}	
	
}
