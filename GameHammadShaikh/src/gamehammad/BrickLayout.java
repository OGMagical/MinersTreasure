package gamehammad;

import java.awt.Rectangle;

/**
 * 
 * @author Hammad Shaikh
 * 
 */

public class BrickLayout {

	// array of brick objects including hitBoxes
	private Brick[] bricks;
	// coordinates of first brick
	private int xPos = 0, yPos = 155, width = 32, height = 32;

	public BrickLayout() {
		// total bricks
		bricks = new Brick[540];
		for (int i = 0; i < bricks.length; i++) {
			// first brick
			if (i == 0) {
				bricks[i] = new Brick(xPos, yPos, width, height);
				// if bricks reach end of screen,
				// reset coordinates to beginning of row
			} else if (xPos > 576) {
				setxPos(0);
				setyPos(yPos + height);
				bricks[i] = new Brick(xPos, yPos, width, height);
			} else {
				// else add width every time to move to next brick
				setxPos(xPos + width);
				bricks[i] = new Brick(xPos, yPos, width, height);
			}
		}
		xPos = 0;
		yPos = 155;
	}

	public void respawn() {
		for (int i = 0; i < bricks.length; i++) {
			bricks[i] = null;
		}
		xPos = 0;
		yPos = 155;
		for (int i = 0; i < bricks.length; i++) {
			if (bricks[i] == null) {
				// first brick
				if (i == 0) {
					bricks[i] = new Brick(xPos, yPos, width, height);
					// if bricks reach end of screen,
					// reset coordinates to beginning of row
				} else if (xPos > 576) {
					setxPos(0);
					setyPos(yPos + height);
					bricks[i] = new Brick(xPos, yPos, width, height);
				} else {
					// else add width every time to move to next brick
					setxPos(xPos + width);
					bricks[i] = new Brick(xPos, yPos, width, height);
				}
			}
		}

	}

	public Brick[] getBricks() {
		return bricks;
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
