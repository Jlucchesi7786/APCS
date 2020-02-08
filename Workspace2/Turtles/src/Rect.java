import TurtleGraphics.*;

public class Rect implements Shape {
	protected double x;
	protected double y;
	
	protected double w;
	private double h;
	
	public Rect() {
		x = 0.0;
		y = 0.0;
		w = 5.0;
		h = 5.0;
	}
	
	public Rect(double x, double y, double h, double w) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}
	
	public double area() {
		return h*w;
	}
	
	public void draw(Pen p) {
		p.up();
		p.turn(90);
		p.move(w/2 - x);
		p.turn(90);
		p.move(h/2 - y);
		p.turn(180);
		p.down();
		for (int i = 0; i < 2; i++) {
			p.move(h);
			p.turn(-90);
			p.move(w);
			p.turn(-90);
		}
		p.up();
		p.turn(90);
		p.move(-(w/2 - x));
		p.turn(90);
		p.move(-(h/2 - y));
		p.turn(180);
		p.down();
	}
	
	public double getXPos() {
		return x;
	}
	
	public double getYPos() {
		return y;
	}
	
	public void move(double xPos, double yPos) {
		this.x = xPos;
		this.y = yPos;
	}
	
	public void stretchBy(double factor) {
		w *= factor;
		h *= factor;
		
	}
	
	public String toString() {
		return "Rect: Center = (" + x + ", " + y + "); height = " + h + "; width = " + w + ";";
	}
}
