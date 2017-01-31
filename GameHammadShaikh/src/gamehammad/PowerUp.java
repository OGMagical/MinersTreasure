package gamehammad;

import java.awt.Rectangle;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class PowerUp {
	//coordinates
	private int xPos, yPos;
	//hitbox
	private Rectangle rec;
	
	public PowerUp(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
		rec = new Rectangle(xPos, yPos, 32, 32);
	}
	public void update(){
		//update position
		rec.x = xPos;
		rec.y = yPos;
	}
	public void spawn(){
		
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
	public Rectangle getRec() {
		return rec;
	}
}

