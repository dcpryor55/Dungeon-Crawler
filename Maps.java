
public class Maps
{
	public char[][] selectMap(int mapChoice)
	{
		switch(mapChoice)
		{
		case 1:
			char[][] map1 = 		
		{
				{'#', '#', '#', '#', '#', '#', '#', '#'},
				{'#', '.', '#', '>', '#', '.', '.', '#'},
				{'#', '.', '#', '+', '#', '.', '.', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '.', '.', '@', '.', 'O', '.', '#'},
				{'#', '.', '+', '.', '.', '.', '.', '#'},
				{'#', '.', '+', '+', '.', '.', '.', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '#', '#', '#', '#', '#', '#', '#'}
		};
			return map1;
		case 2:
			char[][] map2 = 		
		{
				{'#', '#', '#', '#', '#', '#', '#', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '#', '#', '.', '#', '#', '.', '#'},
				{'#', '#', '.', '.', '.', '.', '.', '#'},
				{'#', '+', '.', '.', '.', '.', '.', '#'},
				{'#', '+', '.', '.', '.', '.', '.', '#'},
				{'#', '#', '.', '.', '.', '<', '.', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '.', '.', '.', '.', '.', '.', '#'},
				{'#', '.', '.', '#', '+', '#', '.', '#'},
				{'#', '.', '.', '#', '.', '#', '.', '#'},
				{'#', '.', '.', '#', '>', '#', '.', '#'},
				{'#', '#', '#', '#', '#', '#', '#', '#'}
		};
			return map2;
		}
		
		return null;
	}
	
	public char[][] changeLevel(char[][] currentMap, char[][] newMap)
	{
		
		return newMap;
	}
}		