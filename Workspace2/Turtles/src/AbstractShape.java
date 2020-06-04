import java.util.*;
import TurtleGraphics.*;

public abstract class AbstractShape implements Shape {
	protected double x;
	protected double y;
	
	public abstract double area();
	public abstract void draw(Pen p);
	public final double getXPos() {
		return x;
	}
	public final double getYPos() {
		return y;
	}
	public final void move(double newX, double newY) {
		x = newX;
		y = newY;
	}
	public abstract void stretchBy(double factor);
	public abstract String toString();
}
