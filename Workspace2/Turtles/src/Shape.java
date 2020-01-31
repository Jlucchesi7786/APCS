import TurtleGraphics.*;

public interface Shape {
	public double area ();
	public void draw (Pen p);
	public double getXPos ();
	public double getYPos ();
	public void move (double xPos, double yPos);
	public void stretchBy (double factor);
	public String toString ();
}
