package tetris;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

import tetris.gfx.Assets;
import tetris.input.KeyManager;
import tetris.input.MouseManager;
import tetris.states.GameOverState;
import tetris.states.GameState;
import tetris.states.MenuState;
import tetris.states.States;

public class Game implements Runnable{
	//Variable Declaration
	private String title;
	private int width, height;
	
	//Screen
	private Display display;
	
	//create game thread
	private Thread thread;
	private boolean running=false;
	
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	//States
	public GameState gameState;
	public States menuState;
	public States gameOverState;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//handler 
	private Handler handler;
	
	
	public Game(String title, int width, int height) {
		this.title=title;
		this.height=height;
		this.width=width;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();
		
		int fps = 60;
		double delta = 0;
		double timePerUpdate = 1000000000 / fps;
		long now;
		long lastTime = System.nanoTime();
		long timer=0;
		int ticks=0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now-lastTime) / timePerUpdate;
			timer += now - lastTime;
			lastTime=now;
			
			if(delta>=1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >=1000000000){
	              System.out.println("Ticks and Frames: " + ticks);
	              ticks=0;
	              timer=0;
	          }
			
		}//end of running condition
		stop(); //stops the thread
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	private void update() {
		keyManager.update();
		
		if(States.getState() != null) {
			States.getState().update();
		}
	}
	
	private void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		
		if(bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = bufferStrategy.getDrawGraphics();
		
		graphics.clearRect(0, 0, getWidth(), getHeight());
		
		if(States.getState() != null) {
			States.getState().render(graphics);
		}
		
		bufferStrategy.show();
		graphics.dispose();
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running= false;
		try {
			thread.join();
		}catch (Exception e) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	private void init() {
		display = new Display(title,getWidth(),getHeight());
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		gameOverState = new GameOverState(handler);
		States.setState(menuState);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
}
