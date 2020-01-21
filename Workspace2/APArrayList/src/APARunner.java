
public class APARunner {

	public static void main(String[] args) {
	    System.out.println("SELECTION SORT");
	    APArrayList lst = new APArrayList<Integer>();
	    for (int i=0; i<10; i++) {
	        lst.add ((int)(Math.random()*1000));
	    }
	    System.out.println ("Selection (pre):\n" + lst); 
	    lst.selectionSort();
	    System.out.println ("Selection (post):\n" + lst + "\n");
		lst = new APArrayList<Double>();
		System.out.println("BUBBLE SORT");
		lst = new APArrayList<Integer>();
		for (int i=0; i<10; i++) {
			lst.add ((int)(Math.random()*1000));
		}
		System.out.println ("Bubble (pre):" + lst); 
		lst.bubbleSort();
		System.out.println ("Bubble (post):" + lst + "\n");
		System.out.println("INSERTION SORT");
	    lst = new APArrayList<Integer>();
	    for (int i=0; i<10; i++) {
	        lst.add ((int)(Math.random()*1000));
	    }
	    System.out.println ("Insertion (pre):" + lst); 
	    lst.insertionSort();
	    System.out.println ("Insertion (post):" + lst + "\n");
	}

}
