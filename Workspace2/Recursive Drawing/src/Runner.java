import TurtleGraphics.*;

import java.util.*;

public class Runner {
	public static Scanner reader = new Scanner(System.in);

	static Pen p1;

	public static void main(String[] args) {
		System.out.println("What degree would you like the star to be drawn as?");
		int in2 = reader.nextInt();
		System.out.println("What length would you like the star to have?");
		double in3 = reader.nextDouble();

		System.out.println("Would you like the pen to be standard (S), "
				+ "rainbow (R), or wavy (W)?"); // Rainbow Standard Wiggle
		String s = "" + reader.next();

		if (s.equals("S")) {
			p1 = new StandardPen();
		} else if (s.equals("R")) {
			p1 = new RainbowPen();
		} else if (s.equals("W")) {
			p1 = new WigglePen();
		}
		
		drawStar(p1, in2, in3);
		
		p1.up();
		p1.turn(-90);
		p1.move(in2 * 1.5);
		p1.turn(60);
		p1.down();

		SierTriangle.draw(p1, 240, 3);
	}

	public static void drawStar(Pen p, int degree, double length) {
		p.up();
		p.move(-length/2);
		KochCurve.draw(p, length, degree);
		p.turn(-120);
		KochCurve.draw(p, length, degree);
		p.turn(-120);
		KochCurve.draw(p, length, degree);
		p.turn(-120);
	}
}
