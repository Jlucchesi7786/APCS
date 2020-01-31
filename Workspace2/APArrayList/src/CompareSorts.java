import java.util.Collections;


public class CompareSorts {
	static APArrayList<Double> list = new APArrayList<Double>();
	static APArrayList<Double> list1;
	static APArrayList<Double> list2;
	static APArrayList<Double> list3;
	static APArrayList<Double> list4;
	static String s = "n,ColSort,InsSort,SelSort,BubSort";
	public static void main(String[] args) {
		for (int i = 1000; i < 7000; i += 500) {
			s += "\n" + i + ",";
			for (int n = 0; n < list.size(); n++) {
				list.add(Math.random()*100);
			}
			list1 = list;
			list2 = list;
			list3 = list;
			list4 = list;
			
			long pretime = System.nanoTime();
			Collections.sort(list4);
			long posttime = System.nanoTime();
			s += (posttime-pretime) + ",";
			
			pretime = System.nanoTime();
			list3.insertionSort();
			posttime = System.nanoTime();
			s += (posttime-pretime) + ",";
			
			pretime = System.nanoTime();
			list1.selectionSort();
			posttime = System.nanoTime();
			s += (posttime-pretime) + ",";
			
			pretime = System.nanoTime();
			list2.bubbleSort();
			posttime = System.nanoTime();
			s += (posttime-pretime);
		}
		System.out.println(s);
	}

}
