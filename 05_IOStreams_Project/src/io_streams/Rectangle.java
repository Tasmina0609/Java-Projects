package io_streams;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends MyShape {
	private static final long serialVersionUID = 1L;

	// constructor
	public Rectangle(Color c, int x, int y, int width, int height) {
		type = TYPE.RECT; //to know the shape
		color = c;
		setBounds(x - width / 2, y - height / 2, width, height); //setting bounds to know the size of figure
	}
	
	@Override
	public void setLocation(Point p) {
		super.setLocation(new Point(p.x - getWidth() / 2, p.y - getHeight() / 2));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(getX(), getY(), getWidth(), getHeight()); // rectangle with the current color
	}

}
