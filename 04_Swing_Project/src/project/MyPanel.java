package project;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;

	List<Circle> lstCircles;  // list of Circle type objects
	float radius;
	
	public MyPanel() {
		lstCircles = new ArrayList<Circle>();  // empty list created
	}
	
	public void drawCircle(Circle circle) {
		lstCircles.add(circle);   // adds the circle object to list
		repaint();	  // invokes the paint method
	}	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);	
		
		for( Circle circle: lstCircles)
			circle.paint(g);  // call the method for all objects in the list
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		lstCircles.add(new Circle("ls",Color.MAGENTA,30,40,50));
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e)  {	 }
	@Override
	public void mouseReleased(MouseEvent e) { 	 }
	@Override
	public void mouseEntered(MouseEvent e)  {	 }
	@Override
	public void mouseExited(MouseEvent e)   { 	 }
}




