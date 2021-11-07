import java.util.Arrays;

import org.junit.Test;

public class Split57Test {


	@Test
	public void test1() {
		
		int[] in1 = { 1, 1 };
		boolean[][] exs1 = { {true, false}, {false, true} };
		boolean[] res1 = Split57.split57(in1);
		assertEqualsOneOfExpected(exs1 , res1);
		
		int[] in2 = { 5, 1, 1, 1, 1, 1 };
		boolean[][] exs2 = { {true, false, false, false, false, false} };
		boolean[] res2 = Split57.split57(in2);
		assertEqualsOneOfExpected(exs2 , res2);
		
		int[] in3 = { 4, 5, 1, 7, 2, 9 };
		boolean[][] exs3 = { {false, true, false, false, false, true} };
		boolean[] res3 = Split57.split57(in3);
		assertEqualsOneOfExpected(exs3 , res3);
		
		int[] in4 = {1,2,3,4,5,6,7};
		boolean[][] exs4 = {{true, true, false, false, true, true, false},{false, true, true, true, true, false, false},{false, false, true, false, true, true, false}};
		boolean[] res4 = Split57.split57(in4);
		assertEqualsOneOfExpected(exs4 , res4);
		
	}
	
	@Test
	public void test2() {
		
		int[] in1 = { 1, 1, 1 };
		boolean[][] exs1 = { null };
		boolean[] res1 = Split57.split57(in1);
		assertEqualsOneOfExpected(exs1 , res1);
		
		int[] in2 = { 5, 2, 1, 1, 1, 1 };
		boolean[][] exs2 = { null };
		boolean[] res2 = Split57.split57(in2);
		assertEqualsOneOfExpected(exs2 , res2);
		
		int[] in3 = { 4, 5, 1, 7, 3, 9 };
		boolean[][] exs3 = { null };
		boolean[] res3 = Split57.split57(in3);
		assertEqualsOneOfExpected(exs3 , res3);
		
		int[] in4 = {1,2,3,4,5,6};
		boolean[][] exs4 = {null};
		boolean[] res4 = Split57.split57(in4);
		assertEqualsOneOfExpected(exs4 , res4);
		
		
	}
	
	@Test
	public void test3() {
		
		int[] in1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15 };
		boolean[][] exs1 = {{true, false, false, true, true, false, false, false, false, true, true}, {false, true, true, false, true, false, false, false, false, true, true}};
		boolean[] res1 = Split57.split57(in1);
		assertEqualsOneOfExpected(exs1 , res1);
		
		int[] in2 = {90000001, 1, 7, 8800001, 91, 856, 43, 9001, 89903, 96, 900001, 8, 100001, 99997,  5, 3, 899905001, 1000000002, 94901, 97 };
		boolean[][] exs2 = {{false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, false, false}};
		boolean[] res2 = Split57.split57(in2);
		assertEqualsOneOfExpected(exs2 , res2);
		
		int[] in3 = {90000001, 1, 7, 8800001, 91, 856, 43, 9001, 89903, 96, 903001, 8, 100001, 99997,  5, 3, 899905001, 1000000002, 94901, 97 };
		boolean[][] exs3 = {null};
		boolean[] res3 = Split57.split57(in3);
		assertEqualsOneOfExpected(exs3 , res3);
		
		int[] in4 = {12342,9937,3847,93665,3664,28364,28883,383837,218382,28473,2348882,823848};
		boolean[][] exs4 = {null};
		boolean[] res4 = Split57.split57(in4);
		assertEqualsOneOfExpected(exs4 , res4);
		
	}
	
	
	
	/* Asserted dass einer der Arrays aus 'expected' gleich dem Array 'actual' ist. */
	public void assertEqualsOneOfExpected(boolean[][] expected, boolean[] actual) {
		// Diese Methode enthaelt Konstrukte, welche noch nicht in der Vorlesung behandelt wurden.
		
		for (boolean[] ex : expected) {
			if (Arrays.equals(ex, actual)) {
				return;
			}
		}
		
		StringBuilder buf = new StringBuilder();
		buf.append("expected one of: ");
		boolean first = true;
		for (boolean[] ex : expected) {
			if (!first) {
				buf.append(", ");
			}
			buf.append(Arrays.toString(ex));
			first = false;
		}
		buf.append("   but was: ");
		buf.append(Arrays.toString(actual));
		
		throw new AssertionError(buf);
	}
	
}
