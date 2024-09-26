package dev.umar.tilegame.display;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
public class Display {
		
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width,height;			//pixels
	
	//contructor to intilize title and pixels
	public Display(String title, int width, int height) {
		this.title= title;
		this.width= width;
		this.height= height;
		
		createDisplay();
	}
	//initialize JFrame
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					//to properly close the window on clicking X button
		frame.setResizable(false);												//to use only the pixels provided by us and not any resizing
		frame.setLocationRelativeTo(null);										//to appear at the centre of the screen
		frame.setVisible(true); 												//to make Jframe visible
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));					//set size of the canvas
		canvas.setMaximumSize(new Dimension(width, height));					// so that it can stay within frames limit
		canvas.setMinimumSize(new Dimension(width, height));					//
		canvas.setFocusable(false);
		
		frame.add(canvas);														//adding canvas to frame 
		frame.pack();															//resizing canvas a lil bit so we can see it properly
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
}
