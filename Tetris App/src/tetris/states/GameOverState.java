package tetris.states;

import java.awt.Color;
import java.awt.Graphics;

import tetris.Handler;
import tetris.gfx.Assets;
import tetris.ui.ClickListener;
import tetris.ui.UIImageButton;
import tetris.ui.UIManager;

public class GameOverState extends States{
	
	private UIManager uiManager;

	public GameOverState(Handler handler) {
		super(handler);
		UIImageButton resetbutton = new UIImageButton(300,400,300,100,Assets.reset,new ClickListener(){
            @Override
            public void onClick() {
                //set score to 0
                States.setState(handler.getGame().gameState);
            }
        });//reset button
        
        UIImageButton quit = new UIImageButton(700,400,300,100,Assets.menu_quit_button,new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);
            }
        });
        
        uiManager.addObject(quit);
        uiManager.addObject(resetbutton);
	}

	@Override
	public void update() {
		System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		g.setColor(Color.white);
		
		g.drawImage(Assets.game_over_title,300, 50, 600,100,null);
		
		g.drawRect(300, 400, 300, 100);
		g.drawRect(700, 400, 300, 100);
		uiManager.render(g);
	}

}
