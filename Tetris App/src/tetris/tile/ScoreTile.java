package tetris.tile;

import tetris.gfx.Assets;

public class ScoreTile extends Tile{
	public ScoreTile(int id) {
		super(Assets.wall,id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
