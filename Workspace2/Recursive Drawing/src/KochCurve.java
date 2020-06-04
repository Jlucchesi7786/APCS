import TurtleGraphics.*;

public class KochCurve {
	
	public static void draw(Pen p, double length, int degree) {
		p.down();
		if (degree == 0) {
			p.move(length);
			return;
		}
		draw(p, length/3.0, degree - 1);
		p.turn(60);
		draw(p, length/3.0, degree - 1);
		p.turn(-120);
		draw(p, length/3.0, degree - 1);
		p.turn(60);
		draw(p, length/3.0, degree - 1);
	}
}
