package gamehammad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class GameOverState extends State {
	
	public Animation deadAnim;
	
	public GameOverState(Game game) {
		super(game);
		deadAnim = new Animation(200, Images.playerDead);
	}

	@Override
	public void update() {
		//update animation frames
		deadAnim.update();
		
	}

	@Override
	public void render(Graphics g) {
		//sky
		g.setColor(game.sky);
		g.fillRect(0, 0, 640, 155);
		//background
		g.drawImage(Images.titleBG, 0, 155, null);
		//draw dead player
		g.drawImage(deadAnim.getCurrentFrame(), 300, 150, null);
		//game over message
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.setColor(Color.black);
		g.drawString("GAME OVER", 200, 250);
		//QUIT button
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("QUIT", 550, 40);
		//score
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Score: " + game.getScore(), 250, 100);
		
		
	}

}
