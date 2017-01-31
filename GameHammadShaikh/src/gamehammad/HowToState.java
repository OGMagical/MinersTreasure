package gamehammad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class HowToState extends State {

	public HowToState(Game game) {
		super(game);
	}

	@Override
	public void update() {

		
	}

	@Override
	public void render(Graphics g) {
		//draw controls
		g.fillRect(0, 0, 640, 1000);
		g.drawImage(Images.wasd, 0, 0, null);
		g.drawImage(Images.spaceBar, 55, 150, null);
		g.drawImage(Images.healthBig, 100, 300, null);
		g.drawImage(Images.treasureBig, 100, 420, null);
		g.drawImage(Images.bigSpike, 50, 550, null);
		g.drawImage(Images.bigRock, 90, 550, null);
		
		//print all instructions
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.setColor(Color.red);
		g.drawString("Move up,  down, ", 350, 100);
		g.drawString("left, and right.", 350, 140);
		g.drawString("Use space to dig.", 350, 250);
		g.drawString("Collect health to", 350, 340);
		g.drawString("regain energy.", 350, 380);
		g.drawString("Obtain the treasure", 350, 470);
		g.drawString("to complete the game.", 350, 510);
		g.drawString("Avoid rocks and spikes", 350, 600);
		g.drawString("or lose energy.", 350, 640);
		
		//back button
		g.setColor(Color.BLACK);
		g.drawString("BACK", 550, 40);
		
	}

}
