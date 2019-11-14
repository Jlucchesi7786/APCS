
public class ArrayPractice {
	static String[] school = {"Prospect", "Ridge", "Academy"};
	
	public static void main(String[] args) {
		System.out.println(concat(school));
	}

	public static String concat(String[] array) {
		String s = "";
		for (int i = 0; i < array.length; i++) {
			s += array[i] + " ";
		}
		
		return s;
	}
}
