import java.util.*;

public class APArrayList<E extends Comparable<E>> extends ArrayList<E> {
	
	
	public E midVal() {
		int loc = this.size()/2;
		E val = this.get(loc);
		return val;
	}
	
	public E max() {
		E max = this.get(0);
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).compareTo(max) > 0) {
				max = this.get(i);
			}
		}
		return max;
	}
	
	public void sort() {
		Collections.sort(this);
	}
	
	public int binarySearch(E value) {
		int index = this.size()/2;
		E foundvalue = this.get(index);
		
		int topbound = this.size();
		int bottombound = 0;
		
		do {
			foundvalue = this.get(index);
			if (value.compareTo(foundvalue) < 0) {
				topbound = index;
				index -= (topbound-bottombound)/2;
			} else if (value.compareTo(foundvalue) > 0) {
				bottombound = index;
				index += (topbound-bottombound)/2;
			}
		} while (value != foundvalue);
		return index;
	}
	
	public E min() {
		E min = this.get(0);
		if (this.size() > 0) {
			for (int i = 0; i < this.size(); i++) {
				if (this.get(i).compareTo(min) < 0) min = this.get(i);
			}
			
			return min;
		} else {
			throw new RuntimeException("Error: cannot find minimum value because list is "
					+ "empty.");
		}		
	}
	
	public void swap(int index1, int index2) {
		E firstval = this.get(index1);
		this.set(index1, this.get(index2));
		this.set(index2, firstval);
	}
	
	public void selectionSort() {
		for (int i = 0; i < this.size()-1; i++) {
			E minval = this.get(i);
			int index = i;
			for (int j = i; j < this.size(); j++) {
				if (minval.compareTo(this.get(j)) > 0) {
					minval = this.get(j);
					index = j;
				}
			}
			swap(i, index);
		}
	}
	
	public void bubbleSort() {
		for (int i = 0; i < this.size(); i++) {
			for (int j = 0; j < this.size()-(1+i); j++) {
				E val = this.get(j);
				E nextval = this.get(j+1);
				if (val.compareTo(nextval) > 0) {
					swap(j, j+1);
				}
			}
		}
	}
	
	public void insertionSort() {
		for (int i = 0; i < this.size(); i++) {
			for (int j = i; j > 0; j--) {
				E val = this.get(j);
				E lastval = this.get(j-1);
				if (val.compareTo(lastval) < 0) {
					swap(j, j-1);
				}
			}
		}
	}
	
	public E randVal() {
		int factor = this.size()-1;
		int i = (int) (Math.random()*factor);
		return this.get(i);
	}
	
	public String toString() {
		if (this.size() <= 0) {
			return "Empty";
		}

		String s = "";

		for (int i = 0; i < this.size(); i++) {
			if (i % 5 == 0) s += String.format("\n");
			s += "[" + this.get(i) + "]\t";
		}

		return s;
	}
}
