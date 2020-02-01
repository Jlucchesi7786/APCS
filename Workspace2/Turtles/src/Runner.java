import TurtleGraphics.*;
import java.util.*;

public class Runner {
	static Scanner reader = new Scanner(System.in);
	
	public static void main (String[] argv) {
	 	Rect r1 = new Rect (0.0, 0.0, 10.0, 20.0); 	// create a new Rect
		Pen p1 = new StandardPen ();		// create a Pen to use draw multiple Rects
	 	r1.draw (p1);					// draw initial rectangle to the Pen
	 	r1.stretchBy (10.0);				// scale it to be 10x larger
	 	r1.draw (p1);					// draw it again (now shows 2 rectangles)
	 	r1.move (100.0, 100.0);			// move it to a new centerpoint
	 	r1.draw (p1);					// draw it a third time
		p1.up();					// lift Pen
		p1.move(-100, -100);				// move Pen to below the rectangles
		p1.drawString(""+r1);				// invoke Rect's toString - display it
		p1.move(-100, -115);				// move down
		p1.drawString(""+r1.area());			// display the Rect's area*/
		Circle c1 = new Circle (0.0, 0.0, 10.0); 
		Pen p2 = new StandardPen ();		// Create a separate Pen window
		c1.draw (p2);
		c1.stretchBy (10.0);
		c1.draw (p2);
		c1.move (100.0, 100.0);
		c1.draw (p2);
		p2.up();
		p2.move(-100, -100);
		p2.drawString(""+c1);
		p2.move(-100, -115);
		p2.drawString(""+c1.area());
		Hexagon h1 = new Hexagon (0.0, 0.0, 10.0);
		Pen p3 = new StandardPen();
		h1.draw (p3);
		h1.stretchBy (10.0);
		h1.draw (p3);
		h1.move (100.0, 100.0);
		h1.draw (p3);
		p3.up();
		p3.move(-100, -100);
		p3.drawString(""+h1);
		p3.move(-100, -115);
		p3.drawString(""+h1.area());
		Pen p4 = new StandardPen();
		Shape sh;
		System.out.println("Enter a number to draw a shape. 1 for rectangle, 2 for circle"
				+ ", and 3 for hexagon.");
		int store = reader.nextInt();
		if (store == 1) {
			System.out.println("You have selected Rectangle. \n Please enter "
					+ "an x position for the rectangle to be centered on (as a double).");
			double xPos = reader.nextDouble();
			System.out.println("Next, please enter a y position for the rectangle to be"
					+ " centered on (also double).");
			double yPos = reader.nextDouble();
			System.out.println("Please enter the width of your rectangle (double):");
			double width = reader.nextDouble();
			System.out.println("Lastly, please enter the height of your rectangle "
					+ "(double):");
			double height = reader.nextDouble();
			sh = new Rect(xPos, yPos, width, height);
		} else if (store == 2) {
			System.out.println("You have selected Circle. \n Please enter "
					+ "an x position for the circle to be centered on (as a double).");
			double xPos = reader.nextDouble();
			System.out.println("Next, please enter a y position for the circle to be"
					+ " centered on (also double).");
			double yPos = reader.nextDouble();
			System.out.println("Please enter the radius of your circle (double):");
			double radius = reader.nextDouble();
			sh = new Circle(xPos, yPos, radius);
		} else if (store == 3) {
			System.out.println("You have selected Hexagon. \n Please enter "
					+ "an x position for the hexagon to be centered on (as a double).");
			double xPos = reader.nextDouble();
			System.out.println("Next, please enter a y position for the hexagon to be"
					+ " centered on (also double).");
			double yPos = reader.nextDouble();
			System.out.println("Please enter the side length of your hexagon (double):");
			double side = reader.nextDouble();
			sh = new Hexagon(xPos, yPos, side);
		}
	}

}
