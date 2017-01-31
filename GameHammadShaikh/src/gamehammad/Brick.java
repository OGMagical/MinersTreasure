package gamehammad;

import java.awt.Rectangle;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class Brick{
	
	//# of hits brick can take
	private int health;
	//position
	private int xPos, yPos;
	//hitbox
	private Rectangle rec;
	
	public Brick(int xPos, int yPos, int width,int  height){
		//initialize rectangle hitbox
		health = 3;
		this.xPos = xPos;
		this.yPos = yPos;
		rec = new Rectangle(xPos, yPos, width, height);
		
	}
	
	public Rectangle getRec() {
		return rec;
	}
	public int getHealth() {
		return health;
	}public void setHealth(int health) {
		this.health = health;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}

