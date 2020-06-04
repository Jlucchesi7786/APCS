import TurtleGraphics.*;

public class Polyrunner {

	public static void main(String[] args) {
		Shape [] shapes = new Shape [3];
		shapes[0] = new Rect (-90.0, 10.0, 100.0, 100.0);
		shapes[1] = new Circle (10.0, 10.0, 50.0);
		shapes[2] = new Wheel (10.0, -90.0, 50.0, 6);
		Pen p = new StandardPen ();
		for (Shape s: shapes) {
			s.draw (p);
			System.out.println (s + " area: " + s.area());
		}

	}

}
