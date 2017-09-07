package tetris.entities.creature.figures;

import tetris.Handler;
import tetris.entities.creature.Creature;

public class Ishape extends Creature{
	private Handler handler;
	
	public Ishape(Handler handler, float x, float y) {
		super(handler, x, y, 20,100);
		// TODO Auto-generated constructor stub
		this.handler=handler;
	}
	
	public void update(){
		getInput();
		move();
	}
	
	
	
	

}
