package singleplayer1;

import java.util.ArrayList;

public class Enemy
{
	private int enemyX;
	private int enemyY;
	private int speed;
	private boolean visible;
	Layout layout = new Layout();
	Projectile projectile = new Projectile();
	Character character = new Character();
	
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public Enemy()
	{
		enemyX = (int) (Math.random()*1400);
		enemyY = -100;
		speed = 1;
		visible = true;
	}
	
	public void update()
	{
		enemyY = enemyY + speed;
		
		if(enemyY >= 600)
		{
			layout.gameOver("Game Over!", Score.score);

		}
		
		if(Projectile.getX() < (enemyX+40) && (Projectile.getX() + 10) > enemyX && Projectile.getY() < (enemyY+40) && (projectile.getY() + 20) > enemyY)
		{
			visible = false;
			Score.score = Score.score + 5;
		}
	}

	public void army()
	{
		
		for(int i = 0; i < 100; i++)
		{
			Enemy enemy = new Enemy();
			enemies.add(enemy);
		}
	}

	public int getEnemyX() {
		return enemyX;
	}

	public int getEnemyY() {
		return enemyY;
	}

	public boolean isVisible() {
		return visible;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
}