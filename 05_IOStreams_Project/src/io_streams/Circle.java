package io_streams;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends MyShape {
	private static final long serialVersionUID = 1L;

	// constructor
	public Circle(Color c, int x, int y, int diameter) {
		type = TYPE.CIRCLE; //to know the shape
		color = c;

		setBounds(x - diameter/2, y - diameter/2, diameter, diameter); //setting bounds to know the size of figure
	}
	
	@Override
	public void setLocation(Point p) {
		super.setLocation(new Point(p.x - getWidth()/2, p.y - getHeight()/2));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillOval(getX(), getY(), getWidth(), getHeight()); // oval with the current color
	}
}
