
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
	
	public void remove() {
		if (size > 0) {
			
		} else {
			throw new RuntimeException("Error: the list is empty.");
		}
	}
	
	/**
	 * Adds an item to the end of the DoubleList;	
	 * Precondition: list is not full;   
	 * Postcondition: newDouble is added to the end of the list
	 * @param newDouble the value to be added
	 * @throws RuntimeException if list is full
	*/
	public void add(double newDouble) {
		if (size < list.length) {
			list[size] = newDouble;
			size++;
		} else {
			throw new RuntimeException("Error: the list is full with " + size + "values.");
		}
	}
	
	public int size() {
		return size;
	}
	
	public int maxSize() {
		return list.length;
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
