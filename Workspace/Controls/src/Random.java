
public class Random {

	public static void main(String[] args) {
		thirtyRand();
	}
	public static void writeRand() {
		System.out.println(Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+","+Math.random()+",");
	}
	public static void getRand() {
		double x = 0;
		do {
			x = Math.random();
			System.out.println(x);
		} while (x < .9);
	}
	public static void displayRand() {
		int a = 0;
		for (int i = 0; i < 10; i++) {
			double x = Math.random();
			System.out.println(x);
			if (x >.5) {
				a++;
			}
		}
		System.out.println(a);
	}
	public static void tenRand() {
		for (int i = 0; i < 10; i++) {
			double a = 0;
			a = Math.random()*10;
			System.out.println(a);
		}
	}
	public static void thirtyRand() {
		for (int i = 0; i < 10; i++) {
			double a = 0;
			a = Math.random()*30;
			a += 70;
			System.out.println(a);
		}
	}
}
