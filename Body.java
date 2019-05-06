package singleplayer2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Body implements Runnable, KeyListener 
{	
	private Layout layout;
	private String title;
	private int height;
	private int width;
	private BufferStrategy buffer;
	private Graphics graphics;
	private Thread thread;
	Character character = new Character();
	ObstacleT obstacleT = new ObstacleT();
	ObstacleB obstacleB = new ObstacleB();
	ObstacleR obstacleR = new ObstacleR();
	ObstacleL obstacleL = new ObstacleL();

	public Body(String title, int height, int width)
	{
		this.title = title;
		this.height = height;
		this.width = width;
	}

	public void init() 
	{
		layout = new Layout(title, height, width);
		layout.getFrame().addKeyListener(this);
		obstacleT.army();
		obstacleB.army();
		obstacleR.army();
		obstacleL.army();
	}

	public void draw() {

		buffer = layout.getCanvas().getBufferStrategy();

		if (buffer == null) 
		{
			layout.getCanvas().createBufferStrategy(3);
			return;
		}

		graphics = buffer.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);
		
		new Score().drawScore(graphics);
		new Character().drawCharacter(graphics);

		ArrayList obstaclesT = obstacleT.getObstaclesT();

		for(int i = 0; i < obstaclesT.size(); i++)
		{
			ObstacleT obstacleTop = (ObstacleT) obstaclesT.get(i);
			graphics.setColor(Color.YELLOW);
			graphics.fillOval(obstacleTop.getObstacleTX(), obstacleTop.getObstacleTY(), 40, 40);
		}

		ArrayList obstaclesB = obstacleB.getObstaclesB();

		for(int i = 0; i < obstaclesB.size(); i++)
		{
			ObstacleB obstacleBottom = (ObstacleB) obstaclesB.get(i);
			graphics.setColor(Color.WHITE);
			graphics.fillOval(obstacleBottom.getObstacleBX(), obstacleBottom.getObstacleBY(), 40, 40);
		}
		

		ArrayList obstaclesR = obstacleR.getObstaclesR();

		for(int i = 0; i < obstaclesR.size(); i++)
		{
			ObstacleR obstacleRight = (ObstacleR) obstaclesR.get(i);
			graphics.setColor(Color.GREEN);
			graphics.fillOval(obstacleRight.getObstacleRX(), obstacleRight.getObstacleRY(), 40, 40);
		}
		
		ArrayList obstaclesL = obstacleL.getObstaclesL();

		for(int i = 0; i < obstaclesL.size(); i++)
		{
			ObstacleL obstacleLeft = (ObstacleL) obstaclesL.get(i);
			graphics.setColor(Color.MAGENTA);
			graphics.fillOval(obstacleLeft.getObstacleLX(), obstacleLeft.getObstacleLY(), 40, 40);
		}

		graphics.dispose();
		buffer.show();	
	}

	public void run() 
	{
		
		
		init();

		while (true) 
		{
			Thread.currentThread();

			try
			{
				Thread.sleep(10);
			} 

			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			character.moveCharacter();

			ArrayList obstaclesT = obstacleT.getObstaclesT();

			for(int i = 0; i % 2 == 0; i++)
			{
				ObstacleT obstacleTop = (ObstacleT) obstaclesT.get(i);

				if(obstacleTop.isVisible() == true)
				{
					obstacleTop.update();
				}
				else
				{
					obstaclesT.remove(i);
				}

			}

			ArrayList obstaclesB = obstacleB.getObstaclesB();

			for(int i = 0; i % 2 == 0; i++)
			{
				ObstacleB obstacleBottom = (ObstacleB) obstaclesB.get(i);

				if(obstacleBottom.isVisible() == true)
				{
					obstacleBottom.update();
				}
				else
				{
					obstaclesB.remove(i);
				}
			}
			
			ArrayList obstaclesR = obstacleR.getObstaclesR();

			for(int i = 0; i % 2 == 0; i++)
			{
				ObstacleR obstacleRight = (ObstacleR) obstaclesR.get(i);

				if(obstacleRight.isVisible() == true)
				{
					obstacleRight.update();
				}
				else
				{
					obstaclesR.remove(i);
				}
			}
			
			ArrayList obstaclesL = obstacleL.getObstaclesL();

			for(int i = 0; i % 2 == 0; i++)
			{
				ObstacleL obstacleLeft = (ObstacleL) obstaclesL.get(i);

				if(obstacleLeft.isVisible() == true)
				{
					obstacleLeft.update();
				}
				else
				{
					obstaclesL.remove(i);
				}
			}
			
			

			draw();

		}
	}

	public synchronized void start() 
	{
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop()
	{
		try 
		{
			thread.join();
		}

		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		// fångar error
	}

	public void keyPressed(KeyEvent e) 
	{
		int source = e.getKeyCode();

		if(source == KeyEvent.VK_RIGHT)
		{
			character.setRight(true);
		}

		if (source == KeyEvent.VK_LEFT)
		{
			character.setLeft(true);
		}

		if(source == KeyEvent.VK_UP)
		{
			character.setUp(true);
		}

		if(source == KeyEvent.VK_DOWN)
		{
			character.setDown(true);
		}

	}

	public void keyReleased(KeyEvent e)
	{
		int source = e.getKeyCode();

		if (source == KeyEvent.VK_RIGHT) 
		{
			character.setRight(false);
		}

		if (source == KeyEvent.VK_LEFT)
		{
			character.setLeft(false);
		}

		if(source == KeyEvent.VK_UP)
		{
			character.setUp(false);
		}

		if(source == KeyEvent.VK_DOWN)
		{
			character.setDown(false);
		}

	}

	public void keyTyped(KeyEvent e) 
	{

	}
}
