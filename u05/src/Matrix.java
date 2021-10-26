
public class Matrix {	

	static int[][] toSnail(int[][] matrix) {
		// TODO: Implementieren Sie die Methode
		return null;
	}
	
	static int[][] fromSnail(int[][] snailConstruction) {
		// TODO: Implementieren Sie die Methode
		return null;
	}
	
	static boolean areRowsPositive(int[][] snailConstruction) {
		// TODO: Implementieren Sie die Methode
		return false;
	}
	
	static boolean areRingsDense(int[][] matrix) {
		// TODO: Implementieren Sie die Methode
		return false;
	}
	
	
	/* Printed den Inhalt des Arguments. */
	static void print2dArray(int[][] array) {
		
		String[][] strings = new String[array.length][];
		int biggestSize = 0;
		for (int i = 0; i < array.length; i += 1) {
			int[] row = array[i];
			strings[i] = new String[row.length];
			for (int j = 0; j < row.length; j += 1) {
				strings[i][j] = Integer.toString(row[j]);
				if (strings[i][j].length() > biggestSize) {
					biggestSize = strings[i][j].length();
				}
			}
		}
		
		System.out.print("{");
		for (int i = 0; i < strings.length; i += 1) {
			String[] row = strings[i];
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print("{");
			for (int j = 0; j < row.length; j += 1) {
				if (j != 0) {
					System.out.print(", ");
				}
				int remainder = biggestSize - row[j].length();
				for (int k = 0; k < remainder; k += 1) {
					System.out.print(" ");
				}
				System.out.print(row[j]);
			}
			System.out.print("}");
			if (i == strings.length-1) {
				System.out.println("}");
			} else {
				System.out.println(",");
			}
		}
	}
	
}
