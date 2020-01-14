// check what the previous result was and compare
public class SortRunner {
	static DoubleList lst = new DoubleList();
	public static void main(String[] args) {
		SearchTime();
		/*double find = lst.get(9);
		System.out.println("find: " + find);
		System.out.println(lst.binarySearch(find));*/
	}
	
	static void SearchTime() {
		String s = "Slots,Linear,Binary\n";
		for (int n = 1000; n <= 100000; n += 1000) {
			s += n + ",";
			lst = new DoubleList();
			for (int i = 0; i < n; i++) {
				lst.add(Math.random());
			}
			s += linAvgSearch(n) + ",";
			lst.sort();
			s += binAvgSearch(n) + "\n";
		}
		System.out.println(s);
	}
	
	static int linAvgSearch(int n) {
		int avg = 0;
		long totaltime = 0;
		for (int i = 0; i < n; i++) {
			double val = lst.get(i);
			long start = System.nanoTime();
			lst.indexOf(val);
			long end = System.nanoTime();
			totaltime += (end - start);
		}
		avg = (int) totaltime / n;
		return avg;
	}
	
	static int binAvgSearch(int n) {
		int avg = 0;
		long totaltime = 0;
		for (int i = 0; i < n; i++) {
			double val = lst.get(i);
			long start = System.nanoTime();
			lst.binarySearch(val);
			long end = System.nanoTime();
			totaltime += (end - start);
		}
		avg = (int) totaltime / n;
		return avg;
	}
}
