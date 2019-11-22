
public class Tester {

	public static void main(String[] args) {
		System.out.println ("Testing Constructor");
		DoubleList aList = new DoubleList ();
		System.out.println ("size: " + aList.size());
		System.out.println ("max size: " + aList.maxSize());

		System.out.println ("Testing add and toString");
		System.out.println ("List is: " + aList);
		aList.add (12.0);
		aList.add (-1);
		System.out.println ("List is: " + aList);
		for (int i = 0; i<18; i++) aList.add ((double)i);
		try {
			aList.add (100.0);  // generates an Exception
		}
		catch (Exception e) {
			System.out.println ("Error: " + e);
		}
		System.out.println ("List is: " + aList);

		System.out.println();

		System.out.println("Second list of max size 15");
		DoubleList bList = new DoubleList(15);
		for (int i = 0; i < 15; i++) {
			bList.add(i);
		}
		try {
			bList.add(15);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(bList);
	}

}
