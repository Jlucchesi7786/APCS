import java.util.*;

public class GuessRunner {
	static Scanner reader = new Scanner(System.in);
	static Value compval;
	static Value playerval;
	static int numguesses = 0;
	static boolean playerrun;
	static String response = "";
	
	public static void main(String[] args) {
		System.out.println("This is a guessing game. Would you like to choose a number, "
				+ "or would you like the computer to \nchoose a number? Enter "
				+ "\"me\" for you to decide what number it is, or enter \"comp\" "
				+ " to have the \ncomputer choose a number.");
		boolean set = false;
		do {
			String response = reader.nextLine();
			if (response.equals("me")) {
				compGuess();
				set = true;
			} else if (response.equals("comp")) {
				playerGuess();
				set = true;
			} else if (!set) {
				System.out.println("That is not an answer. Please enter \"me\" or "
						+ "\"comp\".");
			}
		} while (!set);
		System.out.println("Thanks for playing!");
	}

	static void playerGuess() {
		compval = new Value();
		playerval = new Value(0);
		System.out.println("The computer has chosen a number,"
				+ " and you must guess it. The computer will give you feedback \nbased"
				+ " on what you entered until you arrive at the value.");
		do {
			System.out.println("Guess an integer:");
			playerval.setValue(reader.nextInt());
			response = compval.compare(playerval);
			System.out.println(response);
			numguesses++;
		} while (!compval.equals(playerval));
		System.out.println("it took you " + numguesses + " tries to guess the number.");
	}
	
	static void compGuess() {
		compval = new Value(0);
		System.out.println("Enter the number you have chosen:");
		playerval = new Value(reader.nextInt());
		System.out.println("The computer will now guess the number. \n");
		guess();
		System.out.println("it guessed the number!");
		System.out.println("it took the computer " + numguesses + " tries "
				+ "to guess the number.");
	}
	
	static void guess() {
		int interval = 10;
		String lastresponse = "";
		do {
			numguesses++;
			System.out.println("guess " + (numguesses) + ": " + compval);
			lastresponse = response;
			response = playerval.compare(compval);
			if (response.equals("too small")) {
				if (lastresponse.equals("too small") || lastresponse.equals("")) {
					compval = new Value (compval.getValue() + interval);
				} else if (lastresponse.equals("too big")) {
					interval--;
					compval = new Value (compval.getValue() + interval);
				}
			} else if (response.equals("too big")) {
					if (lastresponse.equals("too big")) {
						compval = new Value (compval.getValue() - interval);
					} else if (lastresponse.equals("too small")) {
						interval--;
						compval = new Value (compval.getValue() - interval);
					}
				}
			System.out.println("result: " + response + "\n");
		} while (!compval.equals(playerval));
		numguesses++;
		System.out.println("guess " + numguesses + ": " + compval);
	}
}
