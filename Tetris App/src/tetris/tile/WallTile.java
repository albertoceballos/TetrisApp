package tetris.tile;

import tetris.gfx.Assets;

public class WallTile extends Tile{
	
	public WallTile(int id) {
		super(Assets.wall,id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
