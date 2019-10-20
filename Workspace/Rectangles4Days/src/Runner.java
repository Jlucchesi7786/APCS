public class Runner {
	static APRect r1 = new APRect(3,4);
	static APRect r2 = new APRect(1,5);
	static APRect r3 = new APRect(10,4);
	static APRect r4 = new APRect(6,8);
	public static void main(String[] args) {
		System.out.println("I have implemented extensions 1 and 2. \n");
		beginning();
		System.out.println();
		checkRects();
		System.out.println();
		invertRect();
		System.out.println();
		scaleRect();
		r1.setWidth(3);
		r1.setHeight(4);
		System.out.println(r1);
		similarRects();
	}
	
	static void beginning() {
		System.out.println(r1);
		int w = r1.getWidth();
		int h = r1.getHeight();
		r1.setHeight(w);
		r1.setWidth(h);
		System.out.println(r1);
		
		System.out.println("the area of Rectangle r1 is: " + r1.getArea());
		System.out.println("the diagonal of the Rectangle r1 is: " + r1.getDiagonal());
	}
	
	static void checkRects() {
		if (r1.equals(r2)) {
			System.out.println(r1 + "is the same as \n" + r2);
		} else {
			System.out.println(r1 + "is not the same as \n" + r2);
		}
		if (r1.equals(r1)) {
			System.out.println(r1 + "is the same as \n" + r1);
		} else {
			System.out.println(r1 + "is not the same as \n" + r1);
		}
	}
	
	static void similarRects() {
		if (r1.isSimilar(r4)) {
			System.out.println(r1 + "is similar to \n" + r4);
		} else {
			System.out.println(r1 + "is not similar to \n" + r4);
		}
		if (r1.isSimilar(r3)) {
			System.out.println(r1 + "is similar to \n" + r3);
		} else {
			System.out.println(r1 + "is not similar to \n" + r3);
		}
	}
	
	static void invertRect() {
		System.out.println("I will now invert a rectangle");
		System.out.println(r3);
		r3.invert();
		System.out.println(r3);
	}
	
	static void scaleRect() {
		System.out.println("I'm going to scale a rectangle by a factor of 3.");
		System.out.println(r1);
		r1.scale(3);
		System.out.println(r1);
	}
}