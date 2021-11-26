import java.util.Scanner;

public class Teilfolgen {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		int n = input.nextInt();
		input.close();
		
		subSequences("", s, n);
	}

	public static void subSequences(String prefix, String s, int n) {
		if (n == 0) {
			// "prefix" ist eine Teilfolge der gewünschten Länge
			System.out.println(prefix);
		} else if (!s.isEmpty()) {
			// Man nimmt den ersten Buchstaben...
			subSequences(prefix + s.charAt(0), s.substring(1), n-1);
			// ... oder man nimmt den Buchstaben nicht
			subSequences(prefix, s.substring(1), n);
		}
	}
}
