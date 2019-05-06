public class Projectile1 
{
	private int x, y, speed;
	private boolean visible;
	Character character = new Character();
	Layout layout = new Layout();

	public Projectile1(int startX, int startY)
	{
		x = startX;
		y = startY;
		speed = 10;
		visible = true;
	}

	public void update()
	{
		y = y - speed;

		if(y < 0)
		{
			visible = false;
		}
		
		if(character.character2.x < (x+10) && (character.character2.x + 75) > x && character.character2.y < (y+20) && (character.character2.y + 61) > y)
		{
			layout.endFrame("Player 1 won!!!");
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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