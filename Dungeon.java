import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Dungeon 
{
	public static void main(String[] args) throws IOException, InterruptedException, AWTException
	{		
		Scanner scan = new Scanner(System.in);	
		Robot robot = new Robot();
		Player player = new Player();		
		String move;
		ArrayList<Map> levelSave = new ArrayList<Map>();
		
		int choice;
		int dungeonLevel = 1;
		boolean running = false;
		Maps maps = new Maps();	
		Map map = new Map(maps.selectMap(1),player,dungeonLevel);		

		System.out.println("What is your name, hero?");
		String name = scan.nextLine();
		player.setName(name);		

		do 
		{				
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();			
			map.printMap();			
			map.start = true;
			map.lastNum = map.randNum;			
			
			if(map.action == 0)
			{
				move = scan.next();
				map.updateMap(move);
			}
			
			// Close door
			else if(map.action == 1) 
			{
				move = scan.next();
				map.setAdjacent(move);
				map.action = 0;
			}
			
			// Show chat log
			else if(map.action == 2) 
			{
				do
				{
					System.out.println("Chat log:\n");
					for(int i = 0; i < player.log.size(); i++)
					{						
						System.out.println("_"+player.log.get(i));
					}
					System.out.println("\nBack: x");
					move = scan.next();
				}
				while(!move.equalsIgnoreCase("x"));
				map.action = 0;
			}
			
			// Descend floor
			else if (map.action == 3) 
			{				
				do 
				{
					System.out.println("Descend further? Y/N");
					move = scan.next();
					if(move.equals("Y") && (dungeonLevel == map.dungeonLevel))
					{											
						map.posX = player.getX();
						map.posY = player.getY();
						levelSave.add(map);	
						map = new Map(maps.selectMap(dungeonLevel+1),player,dungeonLevel+1);
						dungeonLevel++;
					}
					
					//currently fixing: need to add floor to levelSave when ascending as well
					else if(move.equals("Y") && dungeonLevel < 15)
					{
						map.posX = player.getX();
						map.posY = player.getY();
						map = levelSave.get(map.dungeonLevel-1);
						player.setX(map.posX);
						player.setY(map.posY);
					}
				}
				while((move.equals("Y") || move.equals("N")) != true);
				map.action = 0;
			}
			
			// Ascend floor
			else if (map.action == 4) 
			{				
				do 
				{
					System.out.println("Go up the stairs? Y/N");
					move = scan.next();
					if(move.equals("Y"))
					{
						map.posX = player.getX();
						map.posY = player.getY();
						map = levelSave.get(map.dungeonLevel-2);
						player.setX(map.posX);
						player.setY(map.posY);
					}
				}
				while((move.equals("Y") || move.equals("N")) != true);
				map.action = 0;
			}
			
			// Open shop
			else if (map.action == 5) 
			{				
				do 
				{
					
					move = scan.next();					
				}
				while(!move.equals("x"));
				map.action = 0;
			}
			
			// Game over
			if(map.gameOver == true) 
			{
				System.out.println("Game over!\n\n1 - Begin anew\n\n2 - Quit");
				do 
				{					
					choice = scan.nextInt();
					if(choice == 1)
					{
						map.gameOver = false;
						map = new Map(maps.selectMap(1),player,dungeonLevel);
						player = new Player();
						dungeonLevel = 1;
						levelSave.clear();
					}					
				}
				while((choice != 1) && (choice != 2));
				
			}
			
			// Quit
			else if(map.quit == true) 
			{
				do
				{
					System.out.println("Are you sure you wish to quit? Y/N");
					move = scan.next();
					if(move.equals("N"))
						map.quit = false;
				}
				while((move.equals("Y") || move.equals("N")) != true);													
			}
		}
		while (!map.gameOver && !map.quit);									
	}
}
