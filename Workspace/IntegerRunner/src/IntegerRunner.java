import java.lang.Integer;

public class IntegerRunner {
	static MyInteger i1 = new MyInteger(10);
	static MyInteger i2 = new MyInteger(10);
	static MyInteger i3 = new MyInteger(20);
	static int x;
	static String s;
	
	public static void main(String[] args) {
		x = i1.intValue();
		s = i2.toString();
		System.out.println("Testing state with .equals");
		if (i1.equals(i2)) {
			System.out.println("i1 = i2");
		} else {
			System.out.println("i1 != i2");
		}
		/*System.out.println("Testing state");
		if (i1.intValue() == i2.intValue()) {
			System.out.println("i1 = i2");
		} else {
			System.out.println("i1 != i2");
		}*/
		/*System.out.println("testing identity");
		if (i1 == i2) {
			System.out.println("i1 = i2");
		} else {
			System.out.println("i1 != i2");
		}*/
		//System.out.println("i1 = " + x);
		//System.out.println("i2 = " + s);
		//System.out.println("i3 = " + i3.toString());
		//System.out.println("i3 = " + i3);
	}

}
