package gamehammad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class WonState extends State{

	public WonState(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(game.sky);
		g.fillRect(0, 0, 640, 155);
		//background
		g.drawImage(Images.titleBG, 0, 155, null);
		//game over message
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.setColor(Color.black);
		g.drawString("You Won", 240, 250);
		//QUIT button
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("QUIT", 550, 40);
		//score
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Score: " + game.getScore(), 270, 100);
		
	}

}
