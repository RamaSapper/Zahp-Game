package singleplayer2;

import java.util.ArrayList;

import singleplayer1.Score;

public class ObstacleB
{
	private  int obstacleBX;
	private  int obstacleBY;
	private int speed;
	private boolean visible;
	Layout layout = new Layout();
	Character character = new Character();
	
	ArrayList<ObstacleB> obstaclesB = new ArrayList<ObstacleB>();
	
	public ObstacleB()
	{
		obstacleBX = (int) (Math.random()*1400);
		obstacleBY = 800;
		speed = 5;
		visible = true;
	}
	
	public void update()
	{
		obstacleBY = obstacleBY - speed;
		
		if(obstacleBY < 0)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleBX+40) && (Character.getCharacter1x() + 60) > obstacleBX && Character.getCharacter1y() < (obstacleBY+40) && (Character.getCharacter1y() + 60) > obstacleBY)
		{
			layout.gameOver("Game Over!", Score.score);
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleB obstacleB = new ObstacleB();
			obstaclesB.add(obstacleB);
		}
	}
	
	public  int getObstacleBX() {
		return obstacleBX;
	}

	public  int getObstacleBY() {
		return obstacleBY;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public ArrayList<ObstacleB> getObstaclesB() {
		return obstaclesB;
	}
}
