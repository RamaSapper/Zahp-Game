package singleplayer2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Layout {

	private String title;
	private int height;
	private int width;
	private JFrame frame;
	private Canvas canvas;
	private JFrame endFrame;

	public Layout(String title, int height, int width)
	{
		this.title = title;
		this.height = height;
		this.width = width;

		createLayout();
	}

	public Layout()
	{

	}

	public void createLayout()
	{
		setFrame(new JFrame(title)); // visar titeln
		getFrame().setSize(width, height); // sätter storleken på rutan
		getFrame().setVisible(true); // visar rutan
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // möjlighet att
		// avsluta
		// programmet
		getFrame().setResizable(false);

		setCanvas(new Canvas()); // sätter färg på rutan
		getCanvas().setPreferredSize(new Dimension(width, height)); // färgar hela rutan
		getCanvas().setBackground(Color.red); //väljer vilken färg
		getCanvas().setFocusable(false); 
		getFrame().add(getCanvas()); //lägger till färgen
	}

	public void gameOver(String text, int score)
	{
		endFrame = new JFrame("End Screen");
		endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endFrame.setLayout(new BorderLayout());
		endFrame.add(new JLabel(text), BorderLayout.CENTER);
		endFrame.pack();
		endFrame.setVisible(true);
		endFrame.setLocationRelativeTo(null);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
}