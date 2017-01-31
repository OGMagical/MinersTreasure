package gamehammad;

import java.util.Random;

/**
 * 
 * @author Hammad Shaikh
 *
 */

public class PowerUpManager {
	//array of health bars
	private PowerUp[] health;
	//array for spikes
	private PowerUp[] spikes;
	//treasur epowerup
	private PowerUp treasure;
	//array for rocks
	private PowerUp[] rocks;
	//random generator ints for spawning powerups
	private int randomX;
	private int randomY;
	Random r;

	public PowerUpManager() {
		//initialize all items
		health = new PowerUp[25];
		spikes = new PowerUp[10];
		treasure = new PowerUp(310, 650);
		rocks = new PowerUp[10];
		r = new Random();
		//spawn all power ups at random locations within range specified
		for (int i = 0; i < health.length; i++) {
			randomX = r.nextInt((610 - 0) + 1) + 0;
			randomY = r.nextInt((950 - 155) + 1) + 155;
			health[i] = new PowerUp(randomX, randomY);
		}
		for (int i = 0; i < spikes.length; i++) {
			randomX = r.nextInt((610) + 1);
			randomY = r.nextInt((950 - 155) + 1) + 155;
			spikes[i] = new PowerUp(randomX, randomY);
		}
		for (int i = 0; i < rocks.length; i++) {
			randomX = r.nextInt((610) + 1);
			randomY = r.nextInt((950 - 155) + 1) + 155;
			rocks[i] = new PowerUp(randomX, randomY);
		}

	}
	public void respawn(){
		for (int i = 0; i < health.length; i++) {
			health[i] = null;
			randomX = r.nextInt((610 - 0) + 1) + 0;
			randomY = r.nextInt((950 - 155) + 1) + 155;
			health[i] = new PowerUp(randomX, randomY);
		}
		for (int i = 0; i < spikes.length; i++) {
			spikes[i] = null;
			randomX = r.nextInt((610) + 1);
			randomY = r.nextInt((950 - 155) + 1) + 155;
			spikes[i] = new PowerUp(randomX, randomY);
		}
		for (int i = 0; i < rocks.length; i++) {
			rocks[i] = null;
			randomX = r.nextInt((610) + 1);
			randomY = r.nextInt((950 - 155) + 1) + 155;
			rocks[i] = new PowerUp(randomX, randomY);
		}
		treasure = null;
		treasure = new PowerUp(310, 650);
	}

	public PowerUp[] getHealth() {
		return health;
	}

	public PowerUp getTreasure() {
		return treasure;
	}

	public PowerUp[] getSpikes() {
		return spikes;
	}

	public PowerUp[] getRocks() {
		return rocks;
	}
}
