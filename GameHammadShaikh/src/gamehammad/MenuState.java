package gamehammad;

import java.awt.Graphics;


/**
 * 
 * @author Hammad Shaikh
 *
 */
public class MenuState extends State {

	public MenuState(Game game){
		super(game);
	}
	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		//background of menu
		g.drawImage(Images.titleBG, 0, 0, null);
		//game title
		g.drawImage(Images.title, 20, 200, null);
		//play button
		g.drawImage(Images.play, 232, 300, null);
		//how to button
		g.drawImage(Images.howTo, 184, 400, null);
		
	}

}
