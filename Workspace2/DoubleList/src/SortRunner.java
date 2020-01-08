
public class SortRunner {

	public static void main(String[] args) {
		DoubleList lst = new DoubleList();
		for (int i = 0; i < 10; i++) {
			lst.add(Math.floor(Math.random()*1000));
		}
		lst.sort();
		System.out.println(lst);
		double find = lst.get(10);
		System.out.println("find: " + find);
		System.out.println(lst.binarySearch(lst.get(10)));
	}

}
