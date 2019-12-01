package io_streams;

import java.awt.Color;

import javax.swing.JComponent;

public abstract class MyShape extends JComponent{
	private static final long serialVersionUID = 1L;

	public enum TYPE {CIRCLE, RECT};
	TYPE type; //shape type
	Color color; // color of circle
	
	TYPE getType() {
		return type;
	}
	
	int getColor() {
		return color.getRGB();
	}
}
