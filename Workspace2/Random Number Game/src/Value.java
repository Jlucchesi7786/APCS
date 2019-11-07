
/**
 * This class holds an integer value and provides some methods to compare two
 * instances of this class.
 * @author Dr. Cheese
 */
public class Value {
	private int val; // this is this instance variable that holds what the stored value is.
	
	/**
	 * This constructor sets the value held to a random number between 0 and 100.
	 */
	public Value() {
		this((int) Math.ceil(Math.random()*100));
	}
	
	/**
	 * This constructor sets the value held to a number specified by the writer.
	 * @param num number to be stored.
	 */
	public Value(int num) {
		this.val = num;
	}
	
	/**
	 * This method returns if one Value object is "too big", "too small", or equal to the 
	 * instance running the class.
	 * @param other other Value object to compare to.
	 * @return the comparison statement between the two Values, with the instance running
	 * the method being the reference frame for the two.
	 */
	public String compare(Value other) {
		if (this.equals(other)) {
			return "you guessed it!";
		} else if (this.val < other.getValue()) {
			return "too big";
		} else if (this.val > other.getValue()) {
			return "too small";
		}
		
		return "";
	}
	
	/**
	 * This method compares the values of two Value instances and returns an integer based
	 * on whether the first value is higher, lower, or the same.
	 * @param other other Value instance to compare to.
	 * @return positive 1 if the first instance is greater, negative 1 if the first 
	 * instance is less, or 0 if they are equal to each other.
	 */
	public int compareTo(Value other) {
		if (this.getValue() > other.getValue()) {
			return 1;
		} else if (this.getValue() < other.getValue()) {
			return -1;
		}
		
		return 0;
	}
	
	/**
	 * This method checks if this instance and another instance are storing the same value.
	 * @param other other Value object to compare to.
	 * @return true if the stored values are the same between the instances, or false
	 * if not.
	 */
	public boolean equals(Value other) {
		if (this.val == other.getValue()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method returns the value held by the class.
	 * @return the value that is held by the class.
	 */
	public int getValue() {
		return val;
	}
	
	/**
	 * This method tells the class to store a new value specified by the writer.
	 * @param newVal the new value to be stored by the class.
	 */
	public void setValue(int newVal) {
		this.val = newVal;
	}
	
	/**
	 * Converts the class into a string holding purely the stored value.
	 */
	public String toString() {
		return "" + val;
	}
}
