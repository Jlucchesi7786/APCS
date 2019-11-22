
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

	public DoubleList(double[] arr) {
		list = new double[arr.length + CHUNK_SIZE];

		for (double item: arr) {
			this.add(item);
		}
	}
	
	public int indexOf(double val) {
		for (int i = 0; i < size; i++) {
			if (this.list[i] == val) {
				return i;
			}
		}
		
		return -1;
	}
	
	public double sum() {
		double sum = 0;
		for (int i = 0; i < size; i++) {
			sum += list[i];
		}
		
		return sum;
	}
	
	public double mean() {
		if (size > 0) {
			return (sum()/size);
		} else {
			throw new RuntimeException("Error: cannot take mean because list is empty.");
		}
	}
	
	public double max() {
		double max = -1000000000.0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (list[i] > max) max = list[i];
			}
			
			return max;
		} else {
			throw new RuntimeException("Error: cannot take mean because list is empty.");
		}		
	}
	
	public double min() {
		double min = 1000000000000000.0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				if (list[i] < min) min = list[i];
			}
			
			return min;
		} else {
			throw new RuntimeException("Error: cannot take mean because list is empty.");
		}		
	}

	public double remove() {
		if (size > 0) {
			size--;
			return list[size+1];
		} else {
			throw new RuntimeException("Error: cannot remove values because the list is empty.");
		}
	}
	
	public void remove(int index) {
		if (index > -1 && index < (size+1)) {
			size--;
			for (int i = index; i < size; i++) {
				list[i] = list[i+1];
			}
		} else {
			throw new RuntimeException("Error: the index you're trying to remove (" + index + ") is out of bounds.");
		}
	}

	/**
	 * Adds an item to the end of the DoubleList;	
	 * Precondition: list is not full;   
	 * Postcondition: newDouble is added to the end of the list
	 * @param newDouble the value to be added
	 * @throws RuntimeException if list is full
	 */
	public void add(double newVal) {
		if (size < list.length) {
			list[size] = newVal;
			size++;
		} else {
			throw new RuntimeException("Error: the list is full with " + size + " values.");
		}
	}
	
	public void add(int index, double newVal) {
		if (index > -1 && index < (size+1)) {
			size++;
			for (int i = size; i > index; i--) {
				list[i+1] = list[i];
			}
			list[index] = newVal;
		} else {
			throw new RuntimeException("Error: the index you're trying to add a value into (" + index + ") is out of bounds");
		}
	}
	
	public void clear() {
		size = 0;
	}
	
	public double get(int index) {
		if (size > 0) {
			return list[index];
		} else {
			throw new RuntimeException("Error: cannot remove values because the list is empty.");
		}	
	}
	
	public void set(int index, double newVal) {
		if (index > -1 && index < size) {
			list[index] = newVal;
		} else {
			throw new RuntimeException("Error: cannot change to new value because the index " + index
					+ " is out of bounds.");	
		}
	}

	public int size() {
		return size;
	}

	public int maxSize() {
		return list.length;
	}
	
	public boolean isEmpty() {
		if (size == 0) return true;
		
		return false;
	}
	
	public boolean equals(DoubleList other) {
		boolean equals = true;
		
		if (other.size() == this.size) {
			for (int i = 0; i < size; i++) {
				if (other.get(i) != this.get(i)) equals = false;
			}
		}
		
		return equals;
	}

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
