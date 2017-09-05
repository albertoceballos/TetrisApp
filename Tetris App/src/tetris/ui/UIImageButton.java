package tetris.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{
	
	private ClickListener clicker;
	private BufferedImage image;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage image,ClickListener clicker) {
		super(x,y,width,height);
		this.clicker=clicker;
		this.image=image;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image,(int) x , (int) y, width, height, null);
		
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		clicker.onClick();
	}

}
