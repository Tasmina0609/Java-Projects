package io_streams;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class Main {

	static Random rgen = new Random();
//constants for the size of the window
	static final int WIDTH = 720;
	static final int HEIGHT = 450;
//constants options of comboBoxes
	final static String[] FIGURES = { "Circle", "Rectangle" };
	final static String[] COLORS = { "Red", "Blue", "Pink", "Cyan" };

	public static void main(String[] args) {

		/* Creating a Frame */
		JFrame window = new JFrame("Mini Project");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		JComboBox<String> comboBox_fig = new JComboBox<String>(FIGURES);//creating box of figures
		JSlider slider_size = new JSlider(10, 100, 30);
		JComboBox<String> comboBox_col = new JComboBox<String>(COLORS);//creating box of colors
		
		JPanel bottomPanel = new JPanel(new GridLayout());// instantiating panel specifying layout for the componets like buttons		
		JRadioButton radioButton_drawMode = new JRadioButton("Draw"); //creating 2 radio button
		JRadioButton radioButton_deleteMode = new JRadioButton("Delete");
		ButtonGroup buttonGroup_modes = new ButtonGroup(); //instantiating 
		//to group buttons (only one button from the group can be chosen)
		buttonGroup_modes.add(radioButton_drawMode);
		buttonGroup_modes.add(radioButton_deleteMode);
		radioButton_drawMode.setSelected(true); //this draw mode is selected as default
		
		//adding components into panel according to layout
		bottomPanel.add(new JLabel("Select mode: ") );
		bottomPanel.add(radioButton_drawMode);
		bottomPanel.add(radioButton_deleteMode);
		bottomPanel.add(comboBox_fig);
		bottomPanel.add(new JLabel("Size:  ", JLabel.RIGHT) );
		bottomPanel.add(slider_size);
		bottomPanel.add(comboBox_col);

		//instantiating MyPanel according to its constructor
		MyPanel mp = new MyPanel(comboBox_fig, slider_size, comboBox_col, radioButton_drawMode);
		//adding listeners to be able to work on panel 
		mp.addMouseListener(mp);
		mp.addMouseMotionListener(mp);

		Menu menu = new Menu(mp); //ading menu bar into mp(MyPanel)
		window.setJMenuBar(menu); // allows to integrate the menu bar in the window
		
		window.add(mp, BorderLayout.CENTER); //adding panelto the frame
		window.add(bottomPanel, BorderLayout.SOUTH);
		window.setVisible(true);//set window visible to appear on the screen
	}

}
