package gamehammad;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class GameState extends State {

//	private BrickLayout layout;
//	private Player player1;
//	private PowerUpManager game.puLayout;
	

	private Animation downAnim, rightAnim, leftAnim, digRightAnim;

	public GameState(Game game) { 
		super(game);	
		//initializing player, Brick layout, and powerUp layout
//		player1 = player;			
//		this.layout = layout;

		//Initializing each player animation
		//state milliseconds per frame
		downAnim = new Animation(200, Images.playerDown);
		rightAnim = new Animation(200, Images.playerRight);
		leftAnim = new Animation(200, Images.playerLeft);
	}

	@Override
	public void update() {
		//need to constantly update animation frames
		downAnim.update();
		rightAnim.update();
		leftAnim.update();

		//update player position
		game.player1.update();
		
		//player gravity
		game.player1.setyPos(game.player1.getyPos() + 1);
		
		for (int i = 0; i < game.layout.getBricks().length; i++) {
			if (game.layout.getBricks()[i] != null) {
				if (game.player1.getRec().intersects(game.layout.getBricks()[i].getRec())) {
					//Keep player from falling through bricks
					//if touching a brick, stay on top of it
					if (i < 20) {
						game.player1.setyPos(game.layout.getBricks()[i].getRec().y - 32);
					} else if (game.layout.getBricks()[i - 20] == null) {
						game.player1.setyPos(game.layout.getBricks()[i].getRec().y - 32);
					}
					//if a brick is destroyed, remove brick and
					//lower player energy
					//increase score
					if (game.layout.getBricks()[i].getHealth() < 1) {
						game.layout.getBricks()[i] = null;
						game.player1.setEnergy(game.player1.getEnergy() - 5);
						game.setScore(game.getScore() + 100);

					}
					//set to game over screen
					//if player energy hits 0
					if (game.player1.getEnergy() < 1) {
						State.setState(game.gameOverState);
					}
				}
			}
		}
		//if player touches health bar,
		//remove health bar
		//increase energy
		for (int i = 0; i < game.puLayout.getHealth().length; i++) {
			if (game.puLayout.getHealth()[i] != null) {
				if (game.player1.getRec().intersects(
						game.puLayout.getHealth()[i].getRec())) {
					game.puLayout.getHealth()[i] = null;
					game.player1.setEnergy(game.player1.getEnergy() + 20);
				}
			}
		}
		//if player touches spike
		//remove spike and lower player energy
		for (int i = 0; i < game.puLayout.getSpikes().length; i++) {
			if (game.puLayout.getSpikes()[i] != null) {
				if (game.player1.getRec().intersects(
						game.puLayout.getSpikes()[i].getRec())) {
					game.puLayout.getSpikes()[i] = null;
					game.player1.setEnergy(game.player1.getEnergy() - 20);
				}
			}
		}
		//if player touches a rock,
		//make player stand on top of rock
		for (int i = 0; i < game.puLayout.getRocks().length; i++) {
			if (game.puLayout.getRocks()[i] != null) {
				if (game.player1.getRec()
						.intersects(game.puLayout.getRocks()[i].getRec())) {
					game.player1.setyPos(game.puLayout.getRocks()[i].getRec().y - 32);
				}
			}
		}
		//If player obtains treasure,
		//send to main menu
		//increase score by 500
		if (game.player1.getRec().intersects(game.puLayout.getTreasure().getRec())) {
			State.setState(game.WonState);
			game.setScore(game.getScore() + 500);
		}
		//if player direction is down and "dig" button pressed
		//take away health from brick being dug
		if (game.player1.getDirection().equalsIgnoreCase("down")
				&& game.getKeyInput().space) {
			for (int i = 0; i < game.layout.getBricks().length; i++) {
				if (game.layout.getBricks()[i] != null) {
					if (game.player1.getRec().intersects(
							game.layout.getBricks()[i].getRec())) {
						game.layout.getBricks()[i].setHealth(game.layout.getBricks()[i]
								.getHealth() - 1);
						game.getKeyInput().space = false;
						game.player1.setyPos(game.layout.getBricks()[i].getRec().y - 32);
					}
				}
			}
		}
		//make player jump when up is pressed
		if (game.getKeyInput().up) {
			game.player1.setyPos(game.player1.getyPos() - 50);
			for (int i = 0; i < game.layout.getBricks().length; i++) {
				if (game.layout.getBricks()[i] != null) {
					if (!game.player1.getRec().intersects(
							game.layout.getBricks()[i].getRec())) {
						game.getKeyInput().up = false;

					}
				}
			}
		}
		//move player right when D is pressed
		//dont let player walk through bricks
		if (game.getKeyInput().right) {
			game.player1.setxPos(game.player1.getxPos() + 1);
			for (int i = 0; i < game.layout.getBricks().length; i++) {
				if (game.layout.getBricks()[i] != null) {
					if (game.layout.getBricks()[i].getRec().x > game.player1.getRec().x
							&& game.layout.getBricks()[i].getRec().y <= game.player1
									.getRec().y + 16) {
						if (game.player1.getRec().intersects(
								game.layout.getBricks()[i].getRec())) {
							game.player1.setxPos(game.layout.getBricks()[i].getRec().x - 32);
						}
					}
				}

			}
		}
		//if direction is right and player is digging
		//decrease brick health on each dig
		if (game.player1.getDirection().equalsIgnoreCase("right")
				&& game.getKeyInput().space) {
			for (int i = 0; i < game.layout.getBricks().length; i++) {
				if (game.layout.getBricks()[i] != null) {
					if (game.layout.getBricks()[i].getRec().x > game.player1.getRec().x
							&& game.layout.getBricks()[i].getRec().y <= game.player1
									.getRec().y + 16) {
						if (game.player1.getRec().intersects(
								game.layout.getBricks()[i].getRec())) {
							game.layout.getBricks()[i]
									.setHealth(game.layout.getBricks()[i]
											.getHealth() - 1);
							game.player1.setxPos(game.layout.getBricks()[i].getRec().x - 32);
							game.getKeyInput().space = false;
						}
					}
				}

			}
		}
		//move player left when A is pressed
		//dont let player walk through bricks
		if (game.getKeyInput().left) {
			game.player1.setxPos(game.player1.getxPos() - 1);
			for (int i = 0; i < game.layout.getBricks().length; i++) {
				if (game.layout.getBricks()[i] != null) {
					if (game.layout.getBricks()[i].getRec().x < game.player1.getRec().x
							&& game.layout.getBricks()[i].getRec().y <= game.player1
									.getRec().y + 16) {
						if (game.player1.getRec().intersects(
								game.layout.getBricks()[i].getRec())) {
							game.player1.setxPos(game.layout.getBricks()[i].getRec().x + 32);
						}
					}
				}

			}
		}
		//if direction is left and player is digging
		//decrease brick health on each dig
		if (game.player1.getDirection().equalsIgnoreCase("left")
				&& game.getKeyInput().space) {
			for (int i = 0; i < game.layout.getBricks().length; i++) {
				if (game.layout.getBricks()[i] != null) {
					if (game.layout.getBricks()[i].getRec().x < game.player1.getRec().x
							&& game.layout.getBricks()[i].getRec().y <= game.player1
									.getRec().y + 16) {
						if (game.player1.getRec().intersects(
								game.layout.getBricks()[i].getRec())) {
							game.layout.getBricks()[i]
									.setHealth(game.layout.getBricks()[i]
											.getHealth() - 1);
							game.player1.setxPos(game.layout.getBricks()[i].getRec().x + 32);
							game.getKeyInput().space = false;
						}
					}
				}

			}
		}
	}

	@Override
	public void render(Graphics g) {
		//sky
		g.setColor(game.sky);
		g.fillRect(0, 0, 640, 155);
		
		//print energy and score
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString("Energy: " + game.player1.getEnergy(), 500, 30);
		g.drawString("Score: " + game.getScore(), 500, 60);

		//draw background
		g.drawImage(Images.bg, 0, 155, null);
		
		//draw bricks
		for (int i = 0; i < game.layout.getBricks().length; i++) {
			if (game.layout.getBricks()[i] != null) {
				g.drawImage(Images.dirt, game.layout.getBricks()[i].getRec().x,
						game.layout.getBricks()[i].getRec().y, null);
			}
		}
		//draw health powerups
		for (int i = 0; i < game.puLayout.getHealth().length; i++) {
			if (game.puLayout.getHealth()[i] != null) {
				g.drawImage(Images.health, game.puLayout.getHealth()[i].getRec().x,
						game.puLayout.getHealth()[i].getRec().y, null);
			}
		}
		//draw spikes
		for (int i = 0; i < game.puLayout.getSpikes().length; i++) {
			if (game.puLayout.getSpikes()[i] != null) {
				g.drawImage(Images.spike, game.puLayout.getSpikes()[i].getRec().x,
						game.puLayout.getSpikes()[i].getRec().y, null);
			}
		}
		//draw rocks
		for (int i = 0; i < game.puLayout.getRocks().length; i++) {
			if (game.puLayout.getRocks()[i] != null) {
				g.drawImage(Images.rock, game.puLayout.getRocks()[i].getRec().x,
						game.puLayout.getRocks()[i].getRec().y, null);
			}
		}
		//draw treasure chest
		g.drawImage(Images.treasure, game.puLayout.getTreasure().getRec().x,
				game.puLayout.getTreasure().getRec().y, null);

		//digDown animation
		if (game.player1.getDirection().equalsIgnoreCase("down")
				&& game.getKeyInput().lastSpace) {
			g.drawImage(Images.digRight, game.player1.getRec().x,
					game.player1.getRec().y - 17, null);
		//draw ready to dig animation
		} else if (game.player1.getDirection().equalsIgnoreCase("down")) {
			g.drawImage(downAnim.getCurrentFrame(), game.player1.getRec().x,
					game.player1.getRec().y - 12, null);
		}
		//draw digRight animation
		if (game.player1.getDirection().equalsIgnoreCase("right")
				&& game.getKeyInput().lastSpace) {
			g.drawImage(Images.digRight, game.player1.getRec().x,
					game.player1.getRec().y - 17, null);
		//draw right walking animation
		} else if (game.player1.getDirection().equalsIgnoreCase("right")) {
			g.drawImage(rightAnim.getCurrentFrame(), game.player1.getRec().x,
					game.player1.getRec().y, null);
		}
		//draw digLeft animation when dig button pressed
		if (game.player1.getDirection().equalsIgnoreCase("left")
				&& game.getKeyInput().lastSpace) {
			g.drawImage(Images.digLeft, game.player1.getRec().x,
					game.player1.getRec().y - 17, null);
		//draw left walking animation
		} else if (game.player1.getDirection().equalsIgnoreCase("left")) {
			g.drawImage(leftAnim.getCurrentFrame(), game.player1.getRec().x,
					game.player1.getRec().y, null);
		}

	}
}
