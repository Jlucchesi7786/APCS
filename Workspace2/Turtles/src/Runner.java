import TurtleGraphics.*;

public class Runner {

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
		p1.drawString(""+r1.area());			// display the Rect's area
	}

}
