public class Projectile2 
{
	private int x, y, speed;
	private boolean visible;
	Character character = new Character();
	Layout layout = new Layout();

	public Projectile2(int startX, int startY)
	{
		x = startX;
		y = startY;
		speed = 10;
		visible = true;
	}

	public void update()
	{
		y = y + speed;

		if(y > 800)
		{
			visible = false;
		}
		
		if(character.character1.x < (x+10) && (character.character1.x + 75) > x && character.character1.y < (y+10) && (character.character1.y + 100) > y)
		{
			layout.endFrame("Player 2 won!!!");
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