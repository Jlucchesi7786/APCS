import java.util.*;

public class Runner {
	static double[] scores = new double[3];
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			print("Enter a number:");
			getScore(i);
		}
		print("Here are the scores:");
		for (int i = 0; i < 3; i++) {
			print("" + scores[i]);
		}

		System.out.println("Minimum: " + min(scores));
		System.out.println("Maximum: " + max(scores));
		System.out.println("Mean: " + mean(scores));
		System.out.println("Median: " + median(scores));

	}

	public static double min(double[] arr) {
		double min = 500;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		return min;
	}

	public static double max(double[] arr) {
		double max = -2;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	public static double mean(double[] arr) {
		double mean = 0;
		for (int i = 0; i < arr.length; i++) {
			mean += arr[i];
		}

		mean /= arr.length;

		return mean;
	}

	public static double median(double[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			double num;

			if (arr[i+1] < arr[i]) {
				num = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = num;
			}
		}

		return arr[arr.length/2];
	}

	public static void getScore(int level) {
		setVal(scores, level);
		while (scores[level] < 0.0 || scores[level] > 100.0) {
			print("Please enter a number between 0 and 100.");
			setVal(scores, level);
		}
	}

	public static void setVal(double[] arr, int level) {
		boolean set = false;
		do {
			try {
				scores[level] = reader.nextDouble();
				set = true;
			} catch (Exception e) {
				print("That is not a number. Please enter a number.");
				String s = reader.nextLine();			
			}
		} while (!set);
	}

	public static void print() {
		print("");
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
}
