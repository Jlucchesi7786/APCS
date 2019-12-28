
/**
 * This object holds a bunch of doubles and can do various things with those doubles.
 * I've implemented the Expand and AddAll extensions.
 * @author Dr. Cheese
 */
public class DoubleList {
	private double[] list;
	private int size;
	private static final int CHUNK_SIZE = 20;

	/**
	 * Sets up the DoubleList with 20 indexes to hold values in.
	 */
	public DoubleList() {
		list = new double[CHUNK_SIZE];
		size = 0;
	}

	/**
	 * Sets up the DoubleList with an inputed amount of indexes to hold values in.
	 * @param maxSize the maximum size of the DoubleList (used instead of CHUNK_SIZE).
	 */
	public DoubleList(int maxSize) {
		list = new double[maxSize];
		this.size = 0;
	}

	/**
	 * Sets up the DoubleList with some preset values and 20 extra indexes
	 * to hold values in.
	 * @param arr some base numbers you want to initialize the DoubleList with.
	 */
	public DoubleList(double[] arr) {
		list = new double[arr.length + CHUNK_SIZE];

		for (double item: arr) {
			this.add(item);
		}
	}
	
	/**
	 * Looks for an inputted double in the DoubleList, then returns the first 
	 * index it can be found in.
	 * @param val the value to search for in the DoubleList.
	 * @return the first index it can be found in, or -1 if it is not found.
	 */
	public int indexOf(double val) {
		for (int i = 0; i < size; i++) {
			if (this.list[i] == val) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * adds up all of the values in the DoubleList, then returns it.
	 * @return the sum of all values in the DoubleList.
	 */
	public double sum() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += list[i];
		}
		
		return sum;
	}
	
	/**
	 * finds the statistical mean of all of the values in the DoubleList,
	 * then returns it.
	 * @return the mean of all of the values.
	 * @throws RuntimeException error if the list is empty.
	 */
	public double mean() {
		if (size > 0) {
			return (sum()/size);
		} else {
			throw new RuntimeException("Error: cannot take mean because list is empty.");
		}
	}
	
	/**
	 * looks for the maximum value in the DoubleList, then returns it.
	 * @return the max value in the DoubleList.
	 * @throws RuntimeException if the list is empty.
	 */
	public double max() {
		double max = -1000000000.0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (list[i] > max) max = list[i];
			}
			
			return max;
		} else {
			throw new RuntimeException("Error: cannot find max value because list is empty.");
		}		
	}
	
	/**
	 * looks for the minimum value in the DoubleList, then returns it.
	 * @return the min value in the DoubleList.
	 * @throws RuntimeException if the list is empty.
	 */
	public double min() {
		double min = 1000000000000000.0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (list[i] < min) min = list[i];
			}
			
			return min;
		} else {
			throw new RuntimeException("Error: cannot find minimum value because list is empty.");
		}		
	}

	/**
	 * "removes" the last value in the DoubleList by decrementing the size.
	 * @return the removed value.
	 * @throws RuntimeException if the list is empty.
	 */
	public double remove() {
		if (size > 0) {
			size--;
			return list[size+1];
		} else {
			throw new RuntimeException("Error: cannot remove values because the list is empty.");
		}
	}
	
	/**
	 * removes a specific value from the DoubleList at the index specified.
	 * @param index which place in the array you'd like to get rid of.
	 * @throws RuntimeException if the index you're trying to access is out of bounds.
	 */
	public void remove(int index) {
		if (index > -1 && index < (size+1)) {
			for (int i = index; i < size; i++) {
				list[i] = list[i+1];
			}
			size--;
		} else {
			throw new RuntimeException("Error: the index you're trying to remove (" + index + ") is out of bounds.");
		}
	}

	/**
	 * Adds an item to the end of the DoubleList;	
	 * Precondition: list is not full;  
	 * Postcondition: newDouble is added to the end of the list;
	 * @param newDouble the value to be added.
	 */
	public void add(double newVal) {
		if (size >= list.length) {
			expand();
		}
		
		list[size] = newVal;
		size++;
	}
	
	/**
	 * adds an item at an index specified.
	 * @param index the index you'd like to put the new value in.
	 * @param newVal the new value you'd like to add to the DoubleList.
	 */
	public void add(int index, double newVal) {
		if (index > -1) {
			if (index >= (size+1)) {
				expand();
			}
			size++;
			for (int i = size; i > index; i--) {
				list[i+1] = list[i];
			}
			list[index] = newVal;
		}
	}
	
	/**
	 * adds all of the values from another DoubleList to the end of this one.
	 * @param other another DoubleList from which to get values.
	 */
	public void addAll(DoubleList other) {
		for (int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}
	
	/**
	 * "removes" all of the values in this DoubleList by setting the size to 0.
	 */
	public void clear() {
		size = 0;
	}
	
	/**
	 * "expands" the DoubleList by creating a new array with a larger size, putting all of
	 * the old values in the new one, and then setting the list variable to reference this
	 * new array.
	 */
	public void expand() {
		double[] newArr = new double[size + CHUNK_SIZE];
		for (int i = 0; i < list.length - 1; i++) {
			newArr[i] = list[i];
		}
		list = newArr;
	}
	
	/**
	 * returns a value at a specified index.
	 * @param index the place in the array you'd like to get the value from.
	 * @return the value held at that place.
	 * @throws RuntimeException if the list is empty
	 */
	public double get(int index) {
		if (size > 0) {
			return list[index];
		} else {
			throw new RuntimeException("Error: cannot get values from an empty list.");
		}	
	}
	
	/**
	 * sets the value at a specified index to a new value.
	 * @param index the index to reference.
	 * @param newVal the new value.
	 * @throws RuntimeException if the index is out of bounds.
	 */
	public void set(int index, double newVal) {
		if (index > -1 && index < size) {
			list[index] = newVal;
		} else {
			throw new RuntimeException("Error: cannot change to new value because the index " + index
					+ " is out of bounds.");	
		}
	}

	/**
	 * gets the size of the DoubleList;
	 * @return the amount of indexes with values in list.
	 */
	public int size() {
		return size;
	}

	/**
	 * gets the max amount of indexes without using the expand() method.
	 * @return the maximum amount of indexes in the current array.
	 */
	public int maxSize() {
		return list.length;
	}
	
	/**
	 * checks if the DoubleList is empty by checking if the size of the array is 0.
	 * @return true if empty (size == 0), false if not (size != 0).
	 */
	public boolean isEmpty() {
		if (size == 0) return true;
		
		return false;
	}
	
	/**
	 * checks if this DoubleList is equal to another by first checking the sizes, and 
	 * then seeing if every value held by both is the same for each index.
	 * @param other another DoubleList.
	 * @return true if the sizes and values are the same, or false if not.
	 */
	public boolean equals(DoubleList other) {
		boolean equals = true;
		
		if (other.size() == this.size) {
			for (int i = 0; i < size; i++) {
				if (other.get(i) != this.get(i)) equals = false;
			}
		} else {
			return false;
		}
		
		return equals;
	}

	/**
	 * toString() method that converts every value in the DoubleList into a String format,
	 * then arranges them in a sort of table.
	 * @author Mr. Caswell
	 */
	public String toString() {
		if (size <= 0) {
			return "Empty";
		}

		String s = "";

		for (int i = 0; i < size; i++) {
			if (i % 5 == 0) s += String.format("\n");
			s += String.format("[%04d]:%14.9f; ", i, list[i]);
		}

		return s;
	}
}
