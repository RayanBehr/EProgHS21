import java.util.Arrays;

public class ArrayUtil {
	
	public static int[] zeroInsert(int[] x) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		
		
		if (x.length <= 1) { // Base case: Falls die Laenge des Arrays kleiner gleich 1 ist.
			return Arrays.copyOf(x, x.length);
		} else { // Rekursiver Fall.
			
			// Wir rufen zeroInsert mit dem Tail des Arrays auf.
			int[] tail = Arrays.copyOf(x, x.length-1);
			int[] tailRes = zeroInsert(tail);
			
			int a = x[x.length-1];
			int b = x[x.length-2];
			
			int[] res;
			if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
				// Falls die letzten beiden Zahlen unterschiedlich positiv oder negativ sind, dann wird eine 0 hinzugefuegt.
				res = Arrays.copyOf(tailRes, tailRes.length + 2);
				res[res.length-1] = a;
				res[res.length-2] = 0;
				res[res.length-3] = b;
			} else {
				// Ansonsten wird keine 0 hinzugefuegt.
				res = Arrays.copyOf(tailRes, tailRes.length + 1);
				res[res.length-1] = a;
			}
			return res;
		}
	}
	
	public static boolean tenFollows(int[] x, int index) {
		// TODO: Vervollstaendigen Sie den Code wie in der Aufgabenbeschreibung beschrieben
		
		if (x.length <= index) {
			return false;
		} else {
			// Wir speichern den Wert vom letzten Element in `last` um zu pruefen, ob das aktuelle Element gleich das zehnfache des letzten Elements ist.
			// Wir fangen beim Index `index` an.
			int idx = index+1;
			int last = x[index];
			
			while(idx < x.length) {
				if (x[idx] == last * 10) {
					return true;
				}
				last = x[idx];
				idx += 1;
			}
			
			return false;
		}
	}
}
