package tetris;

import tetris.audio.AudioPlayer;
import tetris.input.KeyManager;
import tetris.input.MouseManager;
import tetris.world.World;

public class Handler {
	protected int diff;
	private AudioPlayer bgMusic;
	private AudioPlayer menuMusic;
	
	public void playGameMusi(int i) {
		bgMusic = new AudioPlayer("/Music/game_bg_music.wav");
		menuMusic = new AudioPlayer("/Music/menu_bg_music.wav");
		if(i==1) {
			bgMusic.play();
		}
		if(i==2) {
			bgMusic.stop();
		}
	}
	
	public void playSettingMusic(int i) {
		menuMusic = new AudioPlayer("/Music/menu_bg_music.wav");
		if(i==1) {
			menuMusic.play();
		}
		if(i==2) {
			menuMusic.stop();
		}
	}
	
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	private Game game;
	private World world;
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public void setDiff(int i) {
		diff = i;
	}
	
	public int getDiff() {
		return diff;
	}
}
