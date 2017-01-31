package gamehammad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


/**
 * Modified framework from CodeNmore
 *
 */
public class Game implements Runnable {

	private Frame frame;
	public String title;
	public int width, height;
	private int score = 0;

	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	public Color sky;
	
	//states of game
	 State gameState;
	 State menuState;
	 State howToState;
	 State gameOverState;
	 State WonState;
	//keyboard and mouse controls
	private KeyInput keyInput; 
	private MouseInput mouseInput;
	
	//player
	protected Player player1;
	//universal brick layout
	protected BrickLayout layout;
	//universal powerup layout
	protected PowerUpManager puLayout;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		player1 = new Player("You");
		layout = new BrickLayout();
		puLayout = new PowerUpManager();
		keyInput = new KeyInput(this, player1);
		mouseInput = new MouseInput(this);
		sky = new Color(124, 185, 255);
	}

	private void init() {
		//init frame
		frame = new Frame(title, width, height);
		//adding mouse/key listeners
		frame.getFrame().addKeyListener(keyInput);
		frame.getFrame().addMouseListener(mouseInput);
		frame.getFrame().addMouseMotionListener(mouseInput);
		frame.getCanvas().addMouseListener(mouseInput);
		frame.getCanvas().addMouseMotionListener(mouseInput);
		//initialize images
		Images.init();
		//initialize all states
		gameState = new GameState(this);
		menuState = new MenuState(this);
		howToState = new HowToState(this);
		gameOverState = new GameOverState(this);
		WonState = new WonState(this);
		//begin at menu state
		State.setState(menuState);

	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	//constantly run update method om each state
	private void update() {
		if (State.getState()!= null){
			State.getState().update();
		}
	}

	private void render() {
		bs = frame.getCanvas().getBufferStrategy();
		if (bs == null) {
			frame.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// draw
		if(State.getState() != null)
			State.getState().render(g);
		

		// stop
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		//run game at 60 frames per second on every computer
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int updates = 0;

		while (running) {
			keyInput.update();

			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				update();
				render();
				updates++;
				delta--;
			}
			
			if(timer >= 1000000000){
				updates = 0;
				timer = 0;
			}
		}
		stop();
	}
	//access keyboard from everywhere
	public KeyInput getKeyInput() {
		return keyInput;
	}
	//access mouse controls everywhere
	public MouseInput getMouseInput() {
		return mouseInput;
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
