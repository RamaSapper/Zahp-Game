package singleplayer2;

import java.util.ArrayList;

public class ObstacleR
{
	private  int obstacleRX;
	private  int obstacleRY;
	private int speed;
	private boolean visible;
	Layout layout = new Layout();
	Character character = new Character();
	
	ArrayList<ObstacleR> obstaclesR = new ArrayList<ObstacleR>();
	
	public ObstacleR()
	{
		obstacleRX = 1450;
		obstacleRY = (int) (Math.random()*901);
		speed = 5;
		visible = true;
	}
	
	public void update()
	{
		obstacleRX = obstacleRX - speed;
		
		if(obstacleRX < 0)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleRX+40) && (Character.getCharacter1x() + 60) > obstacleRX && Character.getCharacter1y() < (obstacleRY+40) && (Character.getCharacter1y() + 60) > obstacleRY)
		{
			layout.gameOver("Game Over!", Score.score);
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleR obstacleR = new ObstacleR();
			obstaclesR.add(obstacleR);
		}
	}

	public  int getObstacleRX() {
		return obstacleRX;
	}

	public  int getObstacleRY() {
		return obstacleRY;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public ArrayList<ObstacleR> getObstaclesR() {
		return obstaclesR;
	}
}
