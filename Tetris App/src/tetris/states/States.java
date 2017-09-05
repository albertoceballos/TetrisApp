package tetris.states;

import java.awt.Graphics;

import tetris.Handler;

public abstract class States {
	private static States currentState = null;
	
	public static void setState(States states) {
		currentState=states;
	}
	
	public static States getState() {
		return currentState;
	}
	
	protected Handler handler;
	
	public States(Handler handler) {
		this.handler=handler;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
}
