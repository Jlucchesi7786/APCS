import java.util.*;

public class Runner {
	static double[] scores = new double[10];
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			print("Enter a score between 0 and 100:");
			setScore(i);
			if (scores[i] < 0) {
				
			}
		}
		print("Here are the scores:");
		for (int i = 0; i < 3; i++) {
			print("" + scores[i]);
		}

		print("Minimum: " + min(scores));
		print("Maximum: " + max(scores));
		print("Mean: " + mean(scores));
		print("Median: " + median(scores));
	}

	/**
	 * This method calculates the minimum value of the array by checking each value and
	 * seeing if it is lower than the last minimum value.
	 * @param arr Scores array
	 * @return the minimum value from it
	 */
	public static double min(double[] arr) {
		double min = 500;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		return min;
	}

	/**
	 * This method calculates the maximum value of the array by checking each value and
	 * seeing if it is higher than the last maximum value.
	 * @param arr Scores array
	 * @return the maximum value from it
	 */
	public static double max(double[] arr) {
		double max = -2;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	/**
	 * This method calculates the mean value by adding up all of the numbers in the 
	 * array, then dividing by the length of the array.
	 * @param arr Scores array
	 * @return the mean value from it
	 */
	public static double mean(double[] arr) {
		double mean = 0;
		for (int i = 0; i < arr.length; i++) {
			mean += arr[i];
		}

		mean /= arr.length;

		return mean;
	}

	/**
	 * This method calculates the median value of the array by sorting the array.
	 * @param arr Scores array
	 * @return the median value
	 */
	public static double median(double[] arr) {
		for (int q = 0; q < arr.length; q++) {
			for (int i = 0; i < arr.length-1; i++) {
				double num;

				if (arr[i+1] < arr[i]) {
					num = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = num;
				}
			}
		}

		return arr[arr.length/2];
	}

	/**
	 * This method runs with the setVal() method to set the score of a specific place 
	 * in the array.
	 * @param level the place in the array that is being set.
	 */
	public static void setScore(int level) {
		setVal(scores, level);
		while (scores[level] < 0.0 || scores[level] > 100.0) {
			print("Please enter a number b etween 0 and 100.");
			setVal(scores, level);
		}
	}

	/**
	 * This method encompasses a try-catch statement to get each new score from the 
	 * console.
	 * @param arr Scores array
	 * @param level the place in the array that is being set.
	 */
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

	/**
	 * This method prints an empty line to the console.
	 */
	public static void print() {
		print("");
	}
	
	/**
	 * This method prints out a String to the console.
	 * @param s the String to print out to the console.
	 */
	public static void print(String s) {
		System.out.println(s);
	}
}
