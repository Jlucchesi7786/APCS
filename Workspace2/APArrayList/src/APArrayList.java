import java.util.*;

public class APArrayList<E extends Comparable<E>> extends ArrayList<E> {
	
	public int linSearch(E val) {
		for (int i = 0; i < size(); i++) {
			if (val.equals(get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int recSearch(E val) {
		return recSearch(val, 0);
	}
	
	private int recSearch(E val, int index) {
		if (index >= size()) {
			return -1;
		}
		if (val.equals(this.get(index))) {
			return index;
		}
		
		return recSearch(val, index + 1);
	}
	
	public int recBinSearch(E val) {
		return recBinSearch(val, 0, size()-1);
	}
	
	private int recBinSearch(E val, int start, int end) {
		int mid = start + ((end - start) / 2);
		if (val.equals(get(mid))) {
			return mid;
		} else if (start == end) {
			return -1;
		}
		if (val.compareTo(get(mid)) < 0) {
			return recBinSearch(val, start, mid-1);
		} else {
			return recBinSearch(val, mid+1, end);
		}
	}
	
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
		int mid = this.size()/2;
		E foundvalue = get(mid);
		
		int topbound = this.size();
		int bottombound = 0;
		
		do {
			foundvalue = this.get(mid);
			if (value.compareTo(foundvalue) < 0) {
				topbound = mid;
			} else if (value.compareTo(foundvalue) > 0) {
				bottombound = mid;
			}
			
			mid = bottombound + ((topbound - bottombound)/2);
		} while (value != foundvalue);
		return mid;
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
