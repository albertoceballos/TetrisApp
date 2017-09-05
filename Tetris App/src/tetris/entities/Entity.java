package tetris.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import tetris.Handler;

public abstract class Entity {
	
	protected float x;
	protected float y;
	protected int width, height;
	protected Rectangle bounds;
	protected Handler handler;
	
	public Entity(Handler handler,float x,float y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.handler=handler;
		bounds = new Rectangle(0,0,width,height);
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x=x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y=y;
	}
	
	public int getWidht() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidht(int width) {
		this.width=width;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
	}
	
	public boolean checkEntityCollision(float xOffset,float yOffset){
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))) {
				return true;
			}
		}
		return false;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

}
