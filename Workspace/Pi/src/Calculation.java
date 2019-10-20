import java.util.Scanner;

public class Calculation {
	public static double pi;
	public static Scanner reader = new Scanner(System.in);
	public static int mode = 0;
	public static int input = 0;

	public static void main(String[] args) {
		System.out.println("Would you like to approximate by number of terms, to a specific precision, or by generating random values.");
		System.out.println("Enter 1 for number of terms, 2 for specific precision, or 3 for random values.");
		mode = reader.nextInt();

		if (mode == 1) {
			do {
				System.out.println("Enter a whole number of terms that is greater than 1.");
				input = reader.nextInt();
			} while (input < 2);

			pi = terms(input);
		} else if (mode == 2) {
			do {
				System.out.println("Enter how many decimals you would like to be precise to as an integer. The integer must be between 0 and 10.");
				input = reader.nextInt();
			} while (input < 1 || input > 10);
			
			pi = approx(input);
		} else if (mode == 3) {
			do {
				System.out.println("Enter a whole number of random points you would like to use. Please enter at least 100.");
				input = reader.nextInt();
			} while (input < 100);
			
			pi = circle(input);
		} else {
			System.out.println("Sorry, that isn't an acceptable mode number. please rerun the program.");
		}
		
		if (pi != 0) {
			System.out.println("Here is your approximation:" + pi);
		}
		
	}

	public static double terms(int numterms) {
		double a = 0.;
		int term = 1;
		
		int repeats = 0;
		
		boolean positive = true;

		do {
			if (positive) {
				a += 4.0/term;
				positive = false;
			} else {
				a -= 4.0/term;
				positive = true;
			}
			term += 2;
			repeats++;
		} while(repeats<numterms);

		return a;
	}

	public static double approx(int deci) {
		double a = 0.;
		int term = 1;
		boolean positive = true;
		boolean done = false;
		double val = 0.;
		double exp = Math.pow(10, -deci - 1);
		double checking = 1. * exp;
		
		do {
			val = 4./term;
			if (positive) {
				a += val;
				positive = false;
			} else {
				a -= val;
				positive = true;
			}
			term += 2;
			if (val < checking) {
				done = true;
			}
		} while(!done);
		
		return a;
	}
	
	public static double circle(int numvals) {
		double a = 0.;
		int numpoints = 0;
		int numpointsin = 0;
		double pointX = 0.;
		double pointY = 0.;
		double Xsquare = 0.;
		double Ysquare = 0.;
		double output = 0.;
		
		do {
			pointX = Math.random() * 2. - 1;
			pointY = Math.random() * 2. - 1;
			Xsquare = Math.pow(pointX, 2);
			Ysquare = Math.pow(pointY, 2);
			output = Xsquare + Ysquare;
			
			if (output < 1) {
				numpointsin++;
			}
			numpoints++;
		} while (numpoints < numvals);
		
		a = (double) numpointsin/numvals*4.;
		System.out.println(a);
		return a;
	}
}
