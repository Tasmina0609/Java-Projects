package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	static Random rgen = new Random();    
	static boolean buttonClicked = false;  
	static final int WIDTH=1025;
	static final int HEIGHT=600;
	
	public static void main(String[] args) {
		/* Creating a Frame */
		JFrame window = new JFrame("Mini Project");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		final MyPanel mp = new MyPanel(); 
		window.add(mp);    // panel added to the frame
		window.setVisible(true);  
		
		JButton button = new JButton("Click to send the message!!!");
		mp.setLayout(new BorderLayout(0, 0));
		mp.add(button, BorderLayout.SOUTH);
		
		/* Action done with button */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton)
					buttonClicked = true;
			}
		});
		
		/* Circles drawn on panel */
		mp.drawCircle(new Circle("ST", Color.CYAN, 40,150, 50));
		mp.drawCircle(new Circle("IT1", Color.CYAN, 40 + 200, 150, 50));
		mp.drawCircle(new Circle("IT2", Color.CYAN, 40 + 2 * 200, 150, 50));
		mp.drawCircle(new Circle("IT3", Color.CYAN, 40 + 3 * 200, 150, 50));
		mp.drawCircle(new Circle("WT", Color.CYAN, 40 + 4 * 200, 150, 50));

		mp.drawCircle(new Circle("B1", Color.YELLOW, 140, 300, 50));
		mp.drawCircle(new Circle("B2", Color.YELLOW, 140 + 200, 300, 50));
		mp.drawCircle(new Circle("B3", Color.YELLOW, 140 + 2 * 200,300, 50));
		mp.drawCircle(new Circle("B4", Color.YELLOW, 140 + 3 * 200, 300, 50));
		
		/* This will make the main thread wait until the button is clicked */
		while (!buttonClicked) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {   e1.printStackTrace();  }
		}
		
		
		/* The circle drawn again to observe the process */
		mp.drawCircle(new Circle("ST", Color.BLUE, 40,150, 50));
		pauseRandom();

		mp.drawCircle(new Circle("B1", Color.RED, 140, 300, 50));
		pauseRandom();

		mp.drawCircle(new Circle("IT1", Color.BLUE, 40 + 200, 150, 50));
		pauseRandom();

		mp.drawCircle(new Circle("B2", Color.RED, 140 + 200, 300, 50));
		pauseRandom();

		mp.drawCircle(new Circle("IT2", Color.BLUE, 40 + 2 * 200, 150, 50));
		pauseRandom();

		mp.drawCircle(new Circle("B3", Color.RED, 140 + 2 * 200,300, 50));
		pauseRandom();

		mp.drawCircle(new Circle("IT3", Color.BLUE, 40 + 3 * 200, 150, 50));
		pauseRandom();

		mp.drawCircle(new Circle("B4", Color.RED, 140 + 3 * 200, 300, 50));
		pauseRandom();

		mp.drawCircle(new Circle("WT", Color.BLUE, 40 + 4 * 200, 150, 50));  
	}
	/* This method is just for avoiding try-catch too many times within main */
	static void pauseRandom() {  
		try {
			Thread.sleep(rgen.nextInt(2001));  // delay for random number seconds,less than or equal 2 sec
		} catch (InterruptedException e1) {  e1.printStackTrace();  }
	}

}