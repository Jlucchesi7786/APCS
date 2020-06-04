import TurtleGraphics.*;

public class SierTriangle {
	
	public static void draw(Pen p, double length, int degree) {
		p.down();
		if (degree == 0) {
			p.move(length);
			p.turn(-120.0);
			p.move(length);
			p.turn(-120.0);
			p.move(length);
			return;
		}
		draw(p, length/2.0, degree - 1);
		p.up();
		p.turn(-120.0);
		p.move(length/2.0);
		p.down();
		draw(p, length/2.0, degree - 1);
		p.up();
		p.turn(-180.0);
		p.move(length/2.0);
		p.turn(-60.0);
		p.down();
		draw(p, length/2.0, degree - 1);
		p.up();
		p.turn(180.0);
		p.move(length/2.0);
		p.turn(-60.0);
		p.move(length / 2.0);
		p.down();
	}
}
