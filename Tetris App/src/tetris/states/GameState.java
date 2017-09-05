package tetris.states;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

import tetris.Handler;
import tetris.world.World;

public class GameState extends States{
	
	private World world;
	public boolean pause=false;

	public GameState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}
	
	public void createWorld() {
		world = new World("res/worlds/world1.txt",handler);
		handler.setWorld(world);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(!pause) {
			world.update();
			if(handler.getKeyManager().getPause()) {
				pause = true;
				try {
					Thread.sleep(100);
				}catch (Exception e) {
					Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}else {
			System.out.println("pause");
			if(handler.getKeyManager().getPause()) {
				pause=false;
				try {
					Thread.sleep(100);
				} catch(InterruptedException ex) {
					Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		if(pause) {
			g.drawString("pause",500, 500);
		}
		
	}

}
