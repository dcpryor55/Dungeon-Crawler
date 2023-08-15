import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler 
{
	public void readMap()
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("map.txt"));
			String line;

			while((line = reader.readLine()) != null) 
			{
				System.out.println(line);
			}
			reader.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}



