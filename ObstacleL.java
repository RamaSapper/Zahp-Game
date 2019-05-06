package singleplayer2;

import java.util.ArrayList;

import singleplayer1.Score;

public class ObstacleL
{
	private  int obstacleLX;
	private  int obstacleLY;
	private int speed;
	private boolean visible;
	Layout layout = new Layout();
	Character character = new Character();
	
	ArrayList<ObstacleL> obstaclesL = new ArrayList<ObstacleL>();
	
	public ObstacleL()
	{
		obstacleLX = -100;
		obstacleLY = (int) (Math.random()*901);
		speed = 5;
		visible = true;
	}
	
	public void update()
	{
		obstacleLX = obstacleLX + speed;
		
		if(obstacleLX > 1440)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleLX+40) && (Character.getCharacter1x() + 60) > obstacleLX && Character.getCharacter1y() < (obstacleLY+40) && (Character.getCharacter1y() + 60) > obstacleLY)
		{
			layout.gameOver("Game Over!", Score.score);
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleL obstacleL = new ObstacleL();
			obstaclesL.add(obstacleL);
		}
	}

	public  int getObstacleLX() {
		return obstacleLX;
	}

	public  int getObstacleLY() {
		return obstacleLY;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public ArrayList<ObstacleL> getObstaclesL() {
		return obstaclesL;
	}
}
