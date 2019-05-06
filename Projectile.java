package singleplayer1;

public class Projectile
{
	private static int x;
	private static int y;
	private int speed;
	private boolean visible;
	Character character = new Character();

	public Projectile(int startX, int startY)
	{
		x = startX;
		y = startY;
		speed = 10;
		visible = true;
	}
	
	public Projectile()
	{
		
	}

	public void update()
	{
		y = y - speed;

		if(y < 0)
		{
			visible = false;
		}
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Projectile.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Projectile.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}