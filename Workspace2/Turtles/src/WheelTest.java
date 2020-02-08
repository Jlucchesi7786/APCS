import TurtleGraphics.*;

public class WheelTest {

	public static void main(String[] args) {
		Pen p1 = new StandardPen ();
		Wheel w1 = new Wheel (0.0, 0.0, 10., 8); 
		w1.draw (p1);
		w1.stretchBy (10.0);
		w1.draw (p1);
		w1.move (100.0, 100.0);
		w1.draw (p1);
		System.out.println (w1);
		System.out.println (w1.area());
		Square s1 = new Square (0.0, 0.0, 20.0); 
		s1.draw (p1);
		s1.stretchBy (10.0);
		s1.draw (p1);
		s1.move (100.0, 100.0);
		s1.draw (p1);
		System.out.println (s1);
		System.out.println (s1.area());
		Star t1 = new Star (0.0, 0.0, 20.0); 
		t1.draw (p1);
		t1.stretchBy (10.0);
		t1.draw (p1);
		t1.move(100, 100);
		t1.draw(p1);
		System.out.println (t1);
		System.out.println (t1.area());
	}

}
