package tetris.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC
	public static Tile[] tiles = new Tile[400];
	public static Tile wallTile = new WallTile(0);
	public static Tile scoreTile = new ScoreTile(1);
	public static Tile bgTile = new BackGroundTile(2);

	//CLASS
	public static final int TILEWIDTH=40,TILEHEIGHT=40;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture,int id) {
		this.texture=texture;
		this.id=id;
		
		tiles[id]=this;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getId() {
		return id;
	}
}
