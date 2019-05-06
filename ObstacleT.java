package singleplayer2;

import java.util.ArrayList;

import singleplayer1.Score;

public class ObstacleT
{
	private  int obstacleTX;
	private  int obstacleTY;
	private int speed;
	private boolean visible;
	Layout layout = new Layout();
	Character character = new Character();
	
	ArrayList<ObstacleT> obstaclesT = new ArrayList<ObstacleT>();
	
	public ObstacleT()
	{
		obstacleTX = (int) (Math.random()*1400);
		obstacleTY = -100;
		speed = 5;
		visible = true;
	}
	
	public void update()
	{
		obstacleTY = obstacleTY + speed;
		
		if(obstacleTY > 725)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleTX+40) && (Character.getCharacter1x() + 60) > obstacleTX && Character.getCharacter1y() < (obstacleTY+40) && (Character.getCharacter1y() + 60) > obstacleTY)
		{
			layout.gameOver("Game Over!", Score.score);
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleT obstacleT = new ObstacleT();
			obstaclesT.add(obstacleT);
		}
	}

	public  int getObstacleTX() {
		return obstacleTX;
	}

	public  int getObstacleTY() {
		return obstacleTY;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public ArrayList<ObstacleT> getObstaclesT() {
		return obstaclesT;
	}
}
