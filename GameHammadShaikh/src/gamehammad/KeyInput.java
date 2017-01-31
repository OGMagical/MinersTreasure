package gamehammad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Hammad Shaikh
 *
 */
public class KeyInput implements KeyListener {
	public boolean lastSpace = false, lastJump = false;
	public boolean space = false;
	public boolean up, right, down, left;
	private Player player1;
	private Game game;

	public KeyInput(Game game, Player player) {
		this.player1 = player;
		this.game = game;

	}

	public void update() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//controls for main game
		if (State.getState() == game.gameState) {
			//record last state of jump boolean
			//prevents long-pressing of jump button (spam)
			if (lastJump == false) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					lastJump = true;
					up = true;
				} else {
					lastJump = false;
				}
			}
			//record last state of dig boolean
			//prevents long-pressing of dig button (spam)
			if (lastSpace == false) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					lastSpace = true;
					space = true;
				} else {
					lastSpace = false;
				}
				//set direction of player to right 
				if (e.getKeyCode() == KeyEvent.VK_D) {
					player1.setDirection("right");
					right = true;
				}
				//set direction of player to left 
				if (e.getKeyCode() == KeyEvent.VK_A) {
					player1.setDirection("left");
					left = true;

				}
				//set direction of player to down 
				if (e.getKeyCode() == KeyEvent.VK_S) {
					player1.setDirection("down");
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (State.getState() == game.gameState) {
			//set back to false on release
			lastSpace = false;
			lastJump = false;
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				space = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				right = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				left = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				up = false;
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
