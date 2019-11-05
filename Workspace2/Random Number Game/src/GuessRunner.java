import java.util.*;

public class GuessRunner {
	static Scanner reader = new Scanner(System.in);
	static Value compval = new Value();
	static Value playerval = new Value(0);
	static int numguesses;
	
	public static void main(String[] args) {
		System.out.println("This is a guessing game. The computer has chosen a number,"
				+ " and you must guess it. The computer will give you feedback based"
				+ " on what you entered until you arrive at the value.");
		do {
			System.out.println("Enter an integer:");
			playerval.setValue(reader.nextInt());
			String result = compval.compare(playerval);
			System.out.println(result);
			numguesses++;
		} while (!compval.equals(playerval));
		System.out.println("it took you " + numguesses + " tries to guess the number.");
	}

}
