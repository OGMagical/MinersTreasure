package gamehammad;

import java.awt.Graphics;


/**
 * Original framework from CodeNmore
 *
 */
public abstract class State {
	protected Game game;
	protected Player player;
	private static State currentState = null;
	
	public State(Game game){
		this.game = game;
		
	}
	//CLASS
	public abstract void update();
	
	public abstract void render (Graphics g);
	
	//common methods
	public static void setState(State state){
		currentState = state;
	}
	public static State getState(){
		return currentState;
	}
	

	
	
	
}
