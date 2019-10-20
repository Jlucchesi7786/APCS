import java.util.Scanner;

public class Project3 {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		
		String s;
		System.out.println("Would you like the normal or the extension? Type 'n' for normal, and type 'e' for the extension.");
		s = reader.nextLine();
		if (s.equals("e")) {
			System.out.println("would you like to convert nm to latitude? if so, type 'y'");
			s = reader.nextLine();
			if (s.equals("y")) {
				System.out.println("Enter a number of nautical miles");
				int h = reader.nextInt();
				out(h);
			}
		} else {
			System.out.println(out(s));
		}
	}
	
	public static double out(String a) {
		double k;
		double E = 0.0;
		if (a.equals("n")) {
			System.out.println("Type a number of kilometers");
			k = reader.nextDouble();
			E = k*54/100;
		}
		return E;
	}
	
	public static void out(int a){
		int degrees = 0;
		int minutes = 0;
		degrees = a/60;
		minutes = a % 60;
		System.out.println("Longitude: " + degrees + " degrees, " + minutes + " minutes");
	}
}
