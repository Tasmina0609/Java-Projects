package io_streams;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class Menu extends JMenuBar {
	private static final long serialVersionUID = 1L;

	public Menu(MyPanel panel) {

		ActionListener displayMenuListener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				int dialog_result;

				// System.out.println("Used menu element [" + event.getActionCommand() + "]");
				switch (event.getActionCommand()) { // switch on commands of menu bar
				case "New":
					// dialog window appears
					if (MyPanel.getLstFigures().size() != 0) {// if panel is empty then no need to save
						dialog_result = JOptionPane.showConfirmDialog(getParent(),
								"Would you like to save previous project?", "Warning",
								JOptionPane.YES_NO_CANCEL_OPTION);
						// yes no cancel buttons will be inside the dialog

						if (dialog_result == JOptionPane.CANCEL_OPTION) // if chosen option is cancel
																		// or
																		// x button then break
							break;
						if (dialog_result == JOptionPane.YES_OPTION)// if option is yes then save
							save();

						MyPanel.getLstFigures().clear(); // clear the list of MyShape objects
						panel.repaint(); // as nothing is in the list it clears the panel
					}
					break;

				case "Open":
					// dialog window appears
					dialog_result = JOptionPane.YES_NO_CANCEL_OPTION;
					// saving
					if (MyPanel.getLstFigures().size() != 0) {// if panel is empty then no need to save
						JOptionPane.showConfirmDialog(getParent(), "Would you like to save previous project?",
								"Warning", dialog_result);
						
						if (dialog_result == JOptionPane.CANCEL_OPTION) { // if chosen option is cancel
							break;										// or
						}									// x button then break
							
						if (dialog_result == JOptionPane.YES_OPTION) { // if option is yes then save
							save();
						}
					}

					// opening
					try {
						// write the name of the file into dialog text space and store result into
						// filename
						String filename = JOptionPane.showInputDialog(getParent(), "File name: ");
						if (filename == null) { // if noting is written then user changed his mind 
							break;				 // and nothingwill be opened
						}

						MyPanel.getLstFigures().clear();// clearing previous panel as we dont want to open file on the
														// existing one
						FileOperations.readFromFile(filename, MyPanel.getLstFigures()); // read (funtion of
																						// FileOperations class)
						panel.repaint(); // list will be filled so repaint to draw them on the panel
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
				case "Save":
					save();
					break;
				case "Quit":
					System.exit(0);
					break;
				}

			}
		};

		// creation of the menu
		JMenu fileMenu = new JMenu("File");

		// creation and addition of the menu items
		JMenuItem item = new JMenuItem("New", 'n'); // the 2nd parameter is a keybord shortcut
		item.addActionListener(displayMenuListener);
		fileMenu.add(item);
		item = new JMenuItem("Open", 'o');
		item.addActionListener(displayMenuListener);
		fileMenu.add(item);
		item = new JMenuItem("Save", 's');
		item.addActionListener(displayMenuListener);
		fileMenu.add(item);
		fileMenu.addSeparator();
		item = new JMenuItem("Quit", 'q');
		item.addActionListener(displayMenuListener);
		fileMenu.add(item);

		this.add(fileMenu); // allows to integrate the menu in the menu bar
	}

	void save() {
		String filename = JOptionPane.showInputDialog(null, "File name: "); // asking using the dialog to give name to
																			// the file
		filename += ".csv"; // add extension
		try {
			FileOperations.writeToFile(filename, MyPanel.getLstFigures());// function of FileOperations class
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
