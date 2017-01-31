package gamehammad;

import java.awt.image.BufferedImage;

/**
 * 
 * @author CodeNMore
 *
 */

public class Animation {
	private int speed, i;
	private long lastTime, time;
	private BufferedImage[] stills;
	
	public Animation(int speed, BufferedImage[] stills){
		this.speed = speed;
		this.stills = stills;
		i = 0;
		time = 0;
		lastTime = System.currentTimeMillis();	
	}
	
	public void update(){
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(time > speed){
			i++;
			time = 0;
			if(i >= stills.length)
				i = 0;
		}
	}
	
	public BufferedImage getCurrentFrame(){
		return stills[i];
	}
}
