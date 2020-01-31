import TurtleGraphics.*;

public class Circle implements Shape {
	private double x;
	private double y;
	double radius;
	
	public Circle() {
		x = 0;
		y = 0;
		radius = 5;
	}
	
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double area () {
		return (Math.PI * Math.pow(radius, 2));
	}
	
	public void draw (Pen p) {
		p.up();
		p.move((radius + y));
		p.turn(-90);
		p.move(x);
		p.down();
		for (int i = 0; i < 360; i++) {
			p.move((Math.PI/180.0) * radius);
			p.turn(-1.0);
		}
		p.up();
		p.move(-x);
		p.turn(90);
		p.move(-(radius + y));
		p.down();
	}
	
	public void move (double xPos, double yPos) {
		x = xPos;
		y = yPos;
	}
	
	public void stretchBy (double factor) {
		radius *= factor;
	}
	
	public double getXPos () {
		return x;
	}
	
	public double getYPos () {
		return y;
	}
	
	public String toString () {
		return "Circle; Center = (" + x + ", " + y + "); radius = " + radius + ";";
	}
}
