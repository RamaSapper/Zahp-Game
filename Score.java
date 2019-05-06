package singleplayer2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score 
{
	
	public static int score;

	public int drawScore(Graphics graphics)
	{
		String a = Integer.toString(score);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("arial", Font.PLAIN, 20));
		graphics.drawString("Score: ", 1290, 740);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("arial", Font.PLAIN, 33));
		graphics.drawString(a, 1360, 740);
		return 0;
	}
}
