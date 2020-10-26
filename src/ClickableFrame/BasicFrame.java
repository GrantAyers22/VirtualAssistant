package ClickableFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BasicFrame extends JFrame implements MouseListener{

	private JFrame frame;
	// private JDialog textbox;
	private boolean pressed = false;
	
	public BasicFrame(int width, int height) {
		// initializing the frame
		new JFrame("");
		
		this.setSize(new Dimension(width, height));
		
		// add mouse listener
		addMouseListener(this);
	}
	public JFrame getFrame() {
		return frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println("It works you son of a bitch 1");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Oi Cunt");
		pressed = true;

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("It works you son of a bitch 3");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("It works you son of a bitch 4");
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public boolean getPressed() {
		return pressed;
	}
	public void resetPressed() {
		pressed = false;
	}
}
