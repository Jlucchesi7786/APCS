import java.util.*;

public class Runner {
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean running = true;
		do {
			int val = 0;
			System.out.println("Enter an integer:");
			try {
				val = reader.nextInt();
			} catch(Exception e) {
				System.out.println(e);
				val = -1;
				String s = reader.nextLine();
			}
			if (val != -1) {
				running = false;
				System.out.println(val);
			}
		} while (running);
	}
}
