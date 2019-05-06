package singleplayer2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Character 
{
	private boolean left, right, up, down;

	private static int character1x = 680;
	private static int character1y = 350;
	
	Rectangle character1 = new Rectangle(character1x, character1y, 75, 100);	

	public void drawCharacter(Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.fillRect(character1x, character1y, 75, 75);
	}

	public boolean getLeft()
	{
		return left;
	}
	
	public void setLeft(boolean status)
	{
		left = status;
	}

	public boolean getRight()
	{
		return right;
	}

	public void setRight(boolean status)
	{
		right = status;
	}
	
	public boolean getUp()
	{
		return up;
	}
	
	public void setUp(boolean status)
	{
		up = status;
	}
	
	public boolean getDown()
	{
		return down;
	}
	
	public void setDown(boolean status)
	{
		down = status;
	}
	
	public void moveCharacter()
	{
		if(right == true)
		{
			if(character1x < 1375)
			{
				character1x = character1x + 5;
			}
		}

		if(left == true)
		{
			if(character1x > 0)
			{
				character1x = character1x - 5;
			}
		}
		
		if(up == true)
		{
			if(character1y > 0)
			{
				character1y = character1y - 5;
				
			}
		}

		if(down == true)
		{
			if(character1y < 720)
			{
				character1y = character1y + 5;
			}
		}
	}

	public static int getCharacter1x() {
		return character1x;
	}

	public static int getCharacter1y() {
		return character1y;
	}
	
}