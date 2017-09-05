package tetris.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width=40, height=40;
	
	public static BufferedImage l_figure, square_figure, tri_figure, stick_figure;
	public static BufferedImage menu_title ,menu_start_button, menu_quit_button;
	public static BufferedImage game_over_title,reset;
	public static BufferedImage wall,score,bg;
	
	public static void init() {
		SpriteSheet figureSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Icons/figure_sprite_sheet.png"));
		SpriteSheet gameOverSheet = new SpriteSheet(ImageLoader.loadImage("/texture/GameOver/game_over_sprite_sheet.png"));
		SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Menu/menu_sprite_sheet.png"));
		SpriteSheet wallSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Walls/wall_sprite_sheet.png"));
		
		//GameOver
		game_over_title = gameOverSheet.crop(0,0,0,0);
		reset = gameOverSheet.crop(0,0,0,0);
		
		//Figures
		l_figure = figureSheet.crop(0,0,0,0);
		square_figure=figureSheet.crop(0,0,0,0);
		tri_figure = figureSheet.crop(0,0,0,0);
		stick_figure = figureSheet.crop(0,0,0,0);
		
		//Menu
		menu_title = menuSheet.crop(0,0,0,0);
		menu_start_button = menuSheet.crop(0,0,0,0);
		menu_quit_button = menuSheet.crop(0,0,0,0);
		
		//Walls
		wall = wallSheet.crop(0,0,0,0);
		score = wallSheet.crop(0,0,0,0);
		bg = wallSheet.crop(0, 0, 0, 0);
	}

}
