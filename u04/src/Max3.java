
public class Max3 {
	//Bonusaufgabe (Aufgabe 4)
	public static void main(String[] args) {
		
		int[] test1 = new int[] {1, 2, 3, 4, 5};
		int[] result1 = max3(test1);
		int[] expectedResult1 = new int[] {3, 4, 5};
		if (isEqual(result1, expectedResult1)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test2 = new int[] {4, 2, 1, 5, 3};
		int[] result2 = max3(test2);
		int[] expectedResult2 = new int[] {3, 4, 5};
		if (isEqual(result2, expectedResult2)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test3 = new int[] {5, 4, 1, 5, 3};
		int[] result3 = max3(test3);
		int[] expectedResult3 = new int[] {4, 5, 5};
		if (isEqual(result3, expectedResult3)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test4 = new int[] {2, 1, 20};
		int[] result4 = max3(test4);
		int[] expectedResult4 = new int[] {1, 2, 20};
		if (isEqual(result4, expectedResult4)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
		int[] test5 = new int[] {1, 4, -2, 3};
		int[] result5 = max3(test5);
		int[] expectedResult5 = new int[] {1, 3, 4};
		if (isEqual(result5, expectedResult5)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		
	}
	
	public static int[] max3(int[] x) {
		
		int[] arr = new  int[x.length];
		for(int i = 0; i < arr.length; i++)
			arr[i] = x[i];
		for(int u = arr.length-1;arr.length-3 <= u; u--)
			for(int v = 0; v < u; v++)
				if(arr[u] < arr[v] ) {
					int t = arr[u];
					arr[u] = arr[v];
					arr[v] = t;
				}
		
		int[] ret = new int[3];
		ret[0] = arr[arr.length-3];
		ret[1] = arr[arr.length-2];
		ret[2] = arr[arr.length-1];
		
		return ret;
	}
	
	/*
	 * 		for(int u = 0; u < arr.length; u++)
			for(int v = u+1; v < arr.length; v++)
				if(arr[v] < arr[u]) {
					int t = arr[u];
					arr[u] = arr[v];
					arr[v] = t;
				}
	 */
	
	/** Gibt true zurueck, genau dann wenn `x` und `y` die gleichen Werte enthalten oder beide null sind. */ 
	public static boolean isEqual(int[] x, int[] y) {
		
		if (x == null || y == null) {
			return x == y;
		}
		
		if (x.length != y.length) {
			return false;
		} 
		
		int i = 0;
		while (i < x.length) {
			if (x[i] != y[i]) {
				return false;
			}
			i += 1;
		}
		
		return true;
	}

}
