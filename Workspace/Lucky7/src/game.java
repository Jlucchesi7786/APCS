import java.util.Scanner;

public class game {
	public static int bal;
	public static Scanner scan = new Scanner(System.in);
	public static int max;
	public static int numt;
	public static int nummax;
	public static int numwins;
	public static String p;
	public static int roll;
	public static boolean ending = false;

	public static void main(String[] args) {
		System.out.println("Enter a starting balance as an integer");
		bal = scan.nextInt();
		max = bal;	
		System.out.println("Good Luck!");
		
		do {
			System.out.println("");
			numt++;
			bal -= 1;
			roll = roll();
			if (roll == 7) {
				bal += 5;
				System.out.println("You won 5 dollars!");
				numwins++;
			} else if (bal > 0) {
				System.out.println("You lost, try again!");
			} else {
				System.out.println("Oh well, try again next time!");
			}
			if (bal > 0) {
				System.out.println("");
				System.out.println("Your new balance is " + bal + " dollars");
				System.out.println("");
			}
			if (bal > max) {
				max = bal;
				nummax = numt;
			}
		} while (bal > 0);

		System.out.println("");
		System.out.println("Thanks for Playing!");

		if (bal == 0) {
			System.out.println("Your maximum balance was: " + max + " dollars.");
			System.out.println("You played " + numt + " times and won " + numwins + " rounds.");
			if (nummax > 0) {
				System.out.println("To keep your money, you should have stopped after " + nummax + " rounds.");
			} else if (nummax == 0) {
				System.out.println("To keep your money, you shouldn't have started playing.");
			}
		}
	}

	public static int roll() {
		int a = 0;
		
		int r1 = (int)(Math.ceil(Math.random()*6));
		System.out.println("First roll is: " + r1);
		
		int r2 = (int)(Math.ceil(Math.random()*6));
		System.out.println("Second roll is: " + r2);
		
		a = r1+r2;
		return a;
	}
}
