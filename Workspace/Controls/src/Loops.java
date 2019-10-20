
public class Loops {

	public static void main(String[] args) {
		for (int i = 0; i <= 12; i++) {
			System.out.println(i+", ");
		}
		for (int i = 12; i <= 30; i+=3) {
			System.out.println(i+", ");
		}
		for (int i = 100; i >= 0; i -= 2) {
			System.out.println(i+", ");
		}
		for (double i = 1.4; i <= 3.0; i += .2) {
			
			double a = Math.round(i*10.)/10.;
			System.out.println(a+", ");
		}
	}

}
