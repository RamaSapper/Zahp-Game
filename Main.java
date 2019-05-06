package singleplayer2;

import java.io.IOException;

public class Main 
{

	public static void main(String[]args) throws IOException, InterruptedException
	{
		Body Body = new Body("Zahp Game", 900, 1440);
		Body.start();
	}
}
