package gamehammad;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import gamehammad.Player;
/**
 * 
 * @author Hammad Shaikh
 *
 */
public class MouseInput implements MouseListener, MouseMotionListener {

	private boolean leftClick, rightClick;
	public boolean play, highScores, howTo;
	private int xMouse, yMouse;
	private Game game;
	public boolean restart = false;

	public MouseInput(Game game) {
		this.game = game;
	}
	
	public int getxMouse() {
		return xMouse;
	}
	public int getyMouse() {
		return yMouse;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//buttons for menu
		if (State.getState() == game.menuState) {
			//play button
			if (e.getX() >= 232 && e.getX() <= 408 && e.getY() >= 300
					&& e.getY() <= 370) {
				State.setState(game.gameState);
			}
			//how to button
			if(e.getX()>= 184 && e.getX()<= 457 && e.getY()>=400 && e.getY()<= 470){
				State.setState(game.howToState);
			}
		}
		//buttons for how to page
		if (State.getState() == game.howToState) {
//			back button
			if(e.getX()>= 550 && e.getY()<=50){
				State.setState(game.menuState);
			}
		}
		// buttons for game over state
		if (State.getState() == game.gameOverState) {
			//back button
			if(e.getX()>= 550 && e.getY()<=50){
				game.layout.respawn();
				System.out.println("respawned");
				State.setState(game.menuState);
				game.puLayout.respawn();
				game.player1.respawn();
			}
		}
		if (State.getState() == game.WonState) {
			//quit button
			if(e.getX()>= 550 && e.getY()<=50){
				game.layout.respawn();
				State.setState(game.menuState);
				game.player1.respawn();
				game.puLayout.respawn();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//coordinates of mouse
		xMouse = e.getX();
		yMouse = e.getY();

	}

}
