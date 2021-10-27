
public class Matrix {	
	
	public static void main(String[] args) {
		int[][] m = new int[][]
				{
					{1,2,3},
					{4,5,6},
					{7,8,9},
				};
		print2dArray(m);
		m = toSnail(m);
		print2dArray(m);
	}

	static int[][] toSnail(int[][] matrix) {
		// TODO: Konstruiere die Schneckenkonstruktion von matrix
		//assuming matrix.length == matrix[0].length
		//assuming matrix.length > 0
		
		int[][] snail = new //snail matrix
				int[(matrix.length+1)/2][matrix.length*4]; 
				//[<Ring-Level>][<Element>]
		
		for(int k = 0; k < snail.length; k++) {
			int m = 0;
			int i = k; int j = k;
			
			while(i < snail.length - k - 1) {
				snail[k][m] = matrix[i][j]; i++; m++; }
			
			while(j < snail.length - k - 1) {
				snail[k][m] = matrix[i][j]; j++; m++; }
			
			while(0 < i) {
				snail[k][m] = matrix[i][j]; i--; m++; }
			
			while(0 < j) {
				snail[k][m] = matrix[i][j]; j--; m++; }
			//now i and j are back at k,k
		}			
		
		return snail;
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
