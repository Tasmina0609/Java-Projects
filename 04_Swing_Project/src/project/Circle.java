package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Circle extends JComponent {
	private static final long serialVersionUID = 1L;

	private String name;	// text
	private int x, y, rad;  // x-Position , y-Position , height and weight of component
	private Color color;	// color 

	public Circle(String name, Color color, int x, int y, int rad) {
		this.name = name;
		this.color = color;
		this.x = x;    this.y = y;
		this.rad = rad;
	}

	@Override
	public void paint(Graphics g) {
		
		g.setColor(color);	
		g.fillOval(x, y, 2 * rad, 2 * rad);  // oval with the current color 
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Helvetica", Font.BOLD, 25));
		g.drawString(name, x + rad -20, y + rad +5  );  // text on the component
		
		g.setFont(new Font("Arial", Font.PLAIN, 25));   
		if (name.contains("S") && color == Color.BLUE) {  // verify the "ST"
			g.drawString("Message sent!", x-20, y-10);		// indicating the start
		}
		
		if (name.contains("W") && color == Color.BLUE) {  // verify the "WT"
			g.drawString("Message received!", x-70  , y-10);  // indicating the end
		}	
	}
}


