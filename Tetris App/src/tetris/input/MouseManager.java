package tetris.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import tetris.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener
{
	private boolean leftPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	public UIManager getUIManager() {
		return uiManager;
	}
	
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY=e.getY();
		if(uiManager != null) {
			uiManager.onMouseMove(e);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON1){
			leftPressed=true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON3) {
			leftPressed=false;
		}
		if(uiManager != null) {
			uiManager.onMouseRelease(e);
		}
	}
}