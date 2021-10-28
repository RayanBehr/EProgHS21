
public class Matrix {	

	static int[][] toSnail(int[][] matrix) {
		// TODO: Konstruiere die Schneckenkonstruktion von matrix
		//assuming matrix.length == matrix[0].length
		//assuming matrix.length > 0
		
		if(matrix.length == 1) return matrix;
		
		int[][] snail = new int[(matrix.length+1)/2][];//snail matrix
				//[<Ring-Level>][<Element>]
		
		
		for(int k = 0; k < snail.length; k++) {
			
			if((matrix.length-2*k)*4-4 == 0) {
				int[] ring = new int[1];
				ring[0] = matrix[k][k];
				snail[k] = ring; continue; }
			
			int[] ring = new int[(matrix.length-2*k)*4-4];
			int m = 0;
			int i = k; int j = k;
			
			while(!(i == matrix.length - k - 1)) {
				ring[m] = matrix[j][i]; i++; m++; }
			
			while(!(j == matrix.length - k - 1)) {
				ring[m] = matrix[j][i]; j++; m++; }
			
			while(!(k == i)) {
				ring[m] = matrix[j][i]; i--; m++; }
			
			while(!(k == j)) {
				ring[m] = matrix[j][i]; j--; m++; }
			
			snail[k] = ring;
			//now i and j are back at k,k
		}			
		
		return snail;
	}
	
	static int[][] fromSnail(int[][] snailConstruction) {
		int n = snailConstruction[0].length / 4 + 1;
		int[][] matrix = new int[n][n];
		
		for(int k = 0; k < snailConstruction.length; k++) {
			
			
			int m = 0;
			int i = k; int j = k;
			
			if(snailConstruction[k].length == 1) 
				matrix[k][k] = snailConstruction[k][0];
			
			while(!(i == matrix.length - k - 1)) {
				matrix[j][i] = snailConstruction[k][m]; i++; m++; }
			
			while(!(j == matrix.length - k - 1)) {
				matrix[j][i] = snailConstruction[k][m]; j++; m++; }
			
			while(!(k == i)) {
				matrix[j][i] = snailConstruction[k][m]; i--; m++; }
			
			while(!(k == j)) {
				matrix[j][i] = snailConstruction[k][m]; j--; m++; }

			//now i and j are back at k,k
		}	
		
		return matrix;
	}
	
	static boolean areRowsPositive(int[][] snailConstruction) {
		int[][] matrix = fromSnail(snailConstruction);
		//print2dArray(matrix);
		
		for(int j = 0; j < matrix.length; j++) {
			int sum = 0;
			for(int i = 0; i < matrix[0].length; i++)
				sum += matrix[j][i];
			//System.out.println(sum);
			if(sum < 1) return false; //I thougth 0 was non negative
		}
		return true;
	}
	
	static boolean areRingsDense(int[][] matrix) {
		int[][] snail = toSnail(matrix);
		for(int r = 0; r < snail.length; r++) {
			int num0 = 0;
			for(int i = 0; i < snail[r].length; i++)
				if(snail[r][i] == 0) num0++;
			if(num0 > snail[r].length/4) return false; }
		
		return true;
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
