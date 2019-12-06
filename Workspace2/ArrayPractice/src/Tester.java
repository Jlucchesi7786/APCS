
public class Tester {
	static double[][] arr = {{0.1, 0.2, 0.3, 0.5}, {1.1, 1.2, 1.3, 1.5}, {3.1, 3.2, 3.3, 3.5}};
	
	public static void main(String[] args) {
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s += "|-----|-----|-----|-----|\n| ";
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] *= 2;
				s += "" + arr[i][j] + " | ";
			}
			s += "\n";
		}
		s += "|-----|-----|-----|-----|";
		System.out.println(s);
	}
}
