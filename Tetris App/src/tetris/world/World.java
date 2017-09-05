package tetris.world;

import java.awt.Graphics;

import tetris.Handler;
import tetris.entities.EntityManager;
import tetris.tile.Tile;
import tetris.utils.Utils;

public class World {
	
	private int width, height;
	private int[][] tiles;
	private EntityManager entityManager;
	private Handler handler;
	
	public World(String path,Handler handler) {
		this.handler=handler;
		
		//have to add different players
		entityManager = new EntityManager(handler);
		
		loadWorld(path);
		
		//setSpawn
	}
	
	public void update() {
		getEntityManager().update();
	}
	
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x,y).render(g,x * Tile.TILEWIDTH, y* Tile.TILEHEIGHT);
			}
		}
		getEntityManager().render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x<0 || y<0 || x>=width || y>=height) {
			return Tile.bgTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null) {
			return Tile.wallTile;
		}else {
			return t;
		}
	}
	
	private void loadWorld(String path) {
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		//spawn goes here
		
		tiles = new int[width][height];
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y]=Utils.parseInt(tokens[(x+y * width)+8]);
			}
		}
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
