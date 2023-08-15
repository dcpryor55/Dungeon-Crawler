
public class AI 
{				
	public void followPlayer(char[][] map, Player player, NPC npc)
	{
		/*
		System.out.println("\n\nplayer x: ");
		System.out.println("player y: ");
		System.out.println("npc x: ");
		System.out.println("npc y: ");
		*/
		
		int playerX = player.getX();
		int playerY = player.getY();										
		int mobX    = npc.getX();
		int mobY    = npc.getY();
		
		if((playerX < mobX) && (playerY < mobY))
		{
			npc.move(mobX-1, mobY-1);
		}
						
	}
}
