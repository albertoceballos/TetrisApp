package tetris.entities.creature;

import java.awt.Graphics;

import tetris.Handler;
import tetris.entities.Entity;
import tetris.tile.Tile;

public class Creature extends Entity{
	
	public static final float DEFAULT_SPEED=6;
	public static final int DEFAULT_CREATURE_WIDTH=64;
	public static final int DEFAULT_CREATURE_HEIGHT=64;
	
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler,x,y,width,height);
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
	}
	
	public void move() {
		if(!checkEntityCollision(xMove,0f)) {
			moveX();
		}
		
		if(!checkEntityCollision(0f,yMove)) {
			moveY();
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	public void moveX(){
        if(xMove > 0){//Moving right
            
            int tx = (int) (x+xMove+bounds.x+bounds.width) /Tile.TILEWIDTH;
            
            if(!collisionWithTile(tx,(int) (y+bounds.y) /Tile.TILEHEIGHT)
                    && !collisionWithTile(tx,(int)(y+bounds.y+bounds.height) / Tile.TILEHEIGHT)){
                x += xMove;
            }
            
        }else if(xMove<0){//Moving left
            int tx = (int) (x+xMove+bounds.x) /Tile.TILEWIDTH;
            
            if(!collisionWithTile(tx,(int) (y+bounds.y) /Tile.TILEHEIGHT)
                    && !collisionWithTile(tx,(int)(y+bounds.y+bounds.height) / Tile.TILEHEIGHT)){
                x += xMove;
            }
        }
    }
	
	public void moveY(){
        if(yMove <0 ){//up
            int ty = (int) (y + yMove + bounds.y) /Tile.TILEHEIGHT;
            
            if(!collisionWithTile((int) (x+bounds.x) / Tile.TILEWIDTH,ty)
                    && !collisionWithTile((int) (x+bounds.x +bounds.width) / Tile.TILEWIDTH,ty)){
                y += yMove;
            }
            
        }else if(yMove > 0){ //down
            int ty = (int) (y + yMove + bounds.y + bounds.height) /Tile.TILEHEIGHT;
            
            if(!collisionWithTile((int) (x+bounds.x) / Tile.TILEWIDTH,ty)
                    && !collisionWithTile((int) (x+bounds.x +bounds.width) / Tile.TILEWIDTH,ty)){
                y += yMove;
            }
        }
        
    }
	
	public void changeOrientation(){
		//Implement change in animation
	}
	
	public void getInput(){
		
	}
	
	public float getxMove() {
		return xMove;
	}
	
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	
	public float getyMove() {
		return yMove;
	}
	
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed=speed;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
