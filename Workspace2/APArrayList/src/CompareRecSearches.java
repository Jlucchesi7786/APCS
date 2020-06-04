
public class CompareRecSearches {

	public static void main(String[] args) {
		System.out.println("n,Average Regular Recursive Search Time,"
				+ "Average Recursive Binary Search Time,"
				+ "Average Linear Search Time,Average Binary Search Time \n");
		for (int n = 100; n < 1000; n += 100) {
			APArrayList<Double> lst = new APArrayList<Double>();
			
			for (int i = 0; i < n; i++) {
				lst.add(Math.random()*100);
			}
			lst.sort();
			long regRecSearchTime = 0;
			long binRecSearchTime = 0;
			long linSearchTime = 0;
			long binSearchTime = 0;
			
			for (int i = 0; i < n; i += 10) {
				long pretime = System.nanoTime();
				lst.recSearch(lst.get(i));
				long posttime = System.nanoTime();
				regRecSearchTime += (posttime - pretime);
				
				pretime = System.nanoTime();
				lst.recBinSearch(lst.get(i));
				posttime = System.nanoTime();
				binRecSearchTime += (posttime - pretime);
				
				pretime = System.nanoTime();
				lst.linSearch(lst.get(i));
				posttime = System.nanoTime();
				linSearchTime += (posttime - pretime);
				
				pretime = System.nanoTime();
				lst.binarySearch(lst.get(i));
				posttime = System.nanoTime();
				binSearchTime += (posttime - pretime);
			}
			
			double avgRegRecSearchTime = (double) regRecSearchTime / n;
			double avgBinRecSearchTime = (double) binRecSearchTime / n;
			double avgLinSearchTime = (double) linSearchTime / n;
			double avgBinSearchTime = (double) binSearchTime / n;
			System.out.println(n + "," + avgRegRecSearchTime + "," + avgBinRecSearchTime + 
					"," + avgLinSearchTime + "," + avgBinSearchTime + "\n");
		}
	}
}
