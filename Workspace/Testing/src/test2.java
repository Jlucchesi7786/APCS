public class test2 {
	int x;
	int y;
	double z;
	static test3 yessers;
	
	test2() {
		x = 1;
		y = 0;
		z = 1.;
		yessers = new test3();
	}
	
	public static void out(String s) {
		test1.print(s);
	}
}
