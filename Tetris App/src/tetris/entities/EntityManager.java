package tetris.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import tetris.Handler;

public class EntityManager {
	
	private Handler handler;
	//declare player objects
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler) {
		this.handler=handler;
		entities= new ArrayList<>();
		//set player objects
		//addEntity(objects);
	}
	
	public void update() {
		for(int i=0;i<entities.size();i++) {
			Entity e = entities.get(i);
			e.update();
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler handler) {
		this.handler=handler;
	}
	
	public ArrayList<Entity> getEntities(){
		return entities;
	}
	
	//get player objects

}
