import java.util.ArrayList;

public class Obstacle
{
	private int obstacleX;
	private int obstacleY;
	private int speed;
	private boolean visible;
	Character character = new Character();
	Layout layout = new Layout();
	
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public ArrayList<Obstacle> getObstacles()
	{
		return obstacles;
	}

	public Obstacle()
	{
		obstacleX = 1500;
		obstacleY = (int) (Math.random()*901);
		speed = 5;
		visible = true;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getObstacleX() {
		return obstacleX;
	}

	public void setObstacleX(int obstacleX) {
		this.obstacleX = obstacleX;
	}

	public int getObstacleY() {
		return obstacleY;
	}

	public void setObstacleY(int obstacleY) {
		this.obstacleY = obstacleY;
	}

	public void update()
	{
		obstacleX = obstacleX - speed;
		
		if(obstacleX < 0)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleX+40) && (Character.getCharacter1x() + 75) > obstacleX && Character.getCharacter1y() < (obstacleY+40) && (Character.getCharacter1y() + 75) > obstacleY)
		{
			layout.endFrame("Player 2 won!!!");
		}
		
		if(Character.getCharacter2x() < (obstacleX+40) && (Character.getCharacter2x() + 75) > obstacleX && Character.getCharacter2y() < (obstacleY+40) && (Character.getCharacter2y() + 75) > obstacleY)
		{
			layout.endFrame("Player 1 won!!!");
		}
	}
	
	public void multiply()
	{
		for(int i = 0; i < 100; i++)
		{
		Obstacle obstacle = new Obstacle();
		obstacles.add(obstacle);
		}
	}
}
