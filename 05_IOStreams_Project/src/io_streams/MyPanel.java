package io_streams;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.MouseInputListener;

public class MyPanel extends JPanel implements MouseInputListener {// all functions have to be implemented
	private static final long serialVersionUID = 1L;

	final Color[] COLORS = { Color.RED, Color.BLUE, Color.PINK, Color.CYAN };

	static List<MyShape> lstFigures; // List to store MyShape type objects
	MyShape cur_item;
	JComboBox<String> comboBox_fig, comboBox_col;
	JSlider slider_size;
	JRadioButton radioButton_mode;

	/* constructor */
	public MyPanel(JComboBox<String> comboBox_fig, JSlider slider_size, JComboBox<String> comboBox_col,
			JRadioButton radioButton_mode) {
		this.comboBox_fig = comboBox_fig;
		this.slider_size = slider_size;
		this.comboBox_col = comboBox_col;
		this.radioButton_mode = radioButton_mode;

		lstFigures = new ArrayList<MyShape>(); // empty list created
	}

	public static List<MyShape> getLstFigures() {
		return lstFigures;
	}

	public void draw(MyShape comp) {
		lstFigures.add(comp); // adds the circle object to list
		repaint(); // invokes the paintComponent method
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (MyShape item : lstFigures)
			item.paint(g); // call the method for all objects in the list
		// System.out.println(lstFigures.size());//debug purposes
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!radioButton_mode.isSelected()) {// if delete mode is selected
			if (cur_item != null) { // and if clicked on shapes then
				lstFigures.remove(cur_item);// remove from the list this shape
				repaint();// invokes the paintComponent method
			}
			return;
		}

		// get:
		int size = slider_size.getValue(); // size from slider
		Color color = COLORS[comboBox_col.getSelectedIndex()];// color from comboBox

		switch (comboBox_fig.getSelectedIndex()) {// get figure from the combobox and then draw to the panel
		case 0:
			draw(new Circle(color, e.getX(), e.getY(), size));
			break;
		case 1:
			draw(new Rectangle(color, e.getX(), e.getY(), size, size));
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		cur_item = null;

		// loop from the end of the list because last added shapes are in front:
		for (int i = lstFigures.size() - 1; i >= 0; i--) {
			MyShape item = lstFigures.get(i);
			if (item.getBounds().contains(e.getPoint())) {
				cur_item = item;
				return;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
	public void mouseDragged(MouseEvent e) {
		if (cur_item == null)
			return;

		cur_item.setLocation(e.getPoint());//change locatin of selected MyShape object the new
		repaint();// invokes the paintComponent method
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
