package gamehammad;

import java.awt.Rectangle;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class Player {
	
	//player energy
	private int energy = 100;
	//player name
	private String name;
	//hitbox
	private Rectangle rec1;
	//coordinates
	private int xPos = (640/2)-16;
	private int yPos = 155-32;
	//direction facing
	private String direction;
	
	public Player(String name){
		this.name = name;
		direction = "down";
		rec1 = new Rectangle(xPos, yPos, 32, 32 );
	}
	public void update(){
		//keep coordinates updated
		rec1.x = xPos;
		rec1.y = yPos;
	}
	public void respawn(){
		xPos = (640/2)-16;
		yPos = 155-32;
		energy = 100;
		direction = "down";
		
	}
	
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public String getName() {
		return name;
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
	public Rectangle getRec() {
		return rec1;
	}
	
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
