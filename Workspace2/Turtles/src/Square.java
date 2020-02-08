
public class Square extends Rect {
	
	public Square() {
		super();
	}
	
	public Square(double x, double y, double side) {
		super(x, y, side, side);
	}
	
	public String toString() {
		return "Square: Center = (" + x + ", " + y + "); side length = " + w + ";";
	}
}
