
public class Calculations {
	
	public static int checksum(int x) {
		if(x == 0) return 0;
		return (x % 10) + checksum(x / 10);
	}
	
	public static boolean magic7(int a, int b) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		if(a == 7) return true;
		if(b == 7)return true;
		if(Math.abs(a + b) == 7) return true;
		if(Math.abs(a - b) == 7) return true;
		
		return false;
	}
	
	public static boolean fast12(int z) {		
		return (z % 12 <= 2 | z % 12 >= 10)? true : false;
	}
}
