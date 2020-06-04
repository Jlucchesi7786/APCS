
public class RecSearch {

	public static void main(String[] args) {
		APArrayList<Double> lst = new APArrayList<Double> ();
		for (int i = 0; i < 100; i++) {
			lst.add((Math.random() * 100));
		}
		double val = lst.get(50);
		System.out.println (lst.recSearch(val)); // should print 50
		lst.sort();	// must sort for binary sort to work
		val = lst.get(51);		
		System.out.println (lst.recBinSearch (val));
	}
}