import TurtleGraphics.Pen;

public class Star extends Hexagon {
	
	public Star() {
		super();
	}
	
	public Star(double x, double y, double side) {
		super(x, y, side);
	}
	
	public double area() {
		return (6 * (side) * (side/6));
	}
	
	public void draw(Pen p) {
		p.up();
		p.move(y);
		p.turn(-90);
		p.move(x);
		p.move(-side/4);
		p.turn(-90);
		p.move(side/2);
		p.turn(180);
		p.down();
		for (int i = 0; i < 3; i++) {
			p.move(side);
			p.turn(-120);
		}
		p.up();
		p.turn(-60);
		p.move(side/3);
		p.turn(-60);
		p.move(side/3);
		p.turn(120);
		p.down();
		for (int i = 0; i < 3; i++) {
			p.move(side);
			p.turn(120);
		}
		p.up();
		p.turn(60);
		p.move(side/3);
		p.turn(60);
		p.move(side/3);
		p.turn(-120);
		p.move(side/2);
		p.turn(-90);
		p.move(side/4);
		p.turn(180);
		p.move(x);
		p.turn(-90);
		p.move(y);
		p.turn(180);
		p.down();
	}
	
	public String toString() {
		return "Hexagram: Center = (" + x + ", " + y + "); side length = " + side + ";";
	}
}
