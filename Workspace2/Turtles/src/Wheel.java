import TurtleGraphics.*;

public class Wheel extends Circle {
	protected int spokes;
	
	public Wheel() {
		super();
		spokes = 4;
	}
	
	public Wheel(double x, double y, double radius, int spokes) {
		super(x, y, radius);
		this.spokes = spokes;
	}
	
	public void draw(Pen p) {
		super.draw(p);
		p.up();
		p.move(y);
		p.turn(-90);
		p.move(x);
		p.down();
		int turn = 360 / spokes;
		for (int i = 0; i < 360; i += turn) {
			p.turn(turn);
			p.move(radius);
			p.move(-radius);
		}
		p.up();
		p.move(-x);
		p.turn(90);
		p.move(-y);
		p.down();
	}
	
	public int getSpokes() {
		return spokes;
	}
	
	public void setSpokes(int spokes) {
		this.spokes = spokes;
	}
	
	public String toString() {
		return (super.toString() + " spokes = " + spokes + ";");
	}
}
