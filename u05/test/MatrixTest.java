import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {


	@Test
	public void testToSnail1() {
		
		int[][] matrix1 = {{0}};
		int[][] expectedToSnail1 = {{0}};
		assertArrayEquals(expectedToSnail1, Matrix.toSnail(matrix1));
		
		
		int[][] matrix2 = {{0, 1}, 
			               {2, 3}};
		int[][] expectedToSnail2 = {{0, 1, 3, 2}};
		assertArrayEquals(expectedToSnail2, Matrix.toSnail(matrix2));
	}
	
	@Test
	public void testToSnail2() {
		
		int[][] matrix3 = {{0, 1, 2},
			               {3, 4, 5},
		                   {6, 7, 8}};
		int[][] expectedToSnail3 = {{0, 1, 2, 5, 8, 7, 6, 3},
				                    {4}};
		assertArrayEquals(expectedToSnail3, Matrix.toSnail(matrix3));
		
		
		int[][] matrix4 = {{ 0,  1,  2,  3},
				           { 4,  5,  6,  7},
				           { 8,  9, 10, 11},
				           {12, 13, 14, 15}};
		int[][] expectedToSnail4 = {{ 0,  1,  2,  3,  7, 11, 15, 14, 13, 12,  8,  4},
				                    { 5,  6, 10,  9}};
		assertArrayEquals(expectedToSnail4, Matrix.toSnail(matrix4));
	}
	
	@Test
	public void testToSnail3() {
		
		int[][] matrix = {{ 0,  1,  2,  3,  4,  5,  6,  7},
				          { 8,  9, 10, 11, 12, 13, 14, 15},
				          {16, 17, 18, 19, 20, 21, 22, 23},
			              {24, 25, 26, 27, 28, 29, 30, 31},
				          {32, 33, 34, 35, 36, 37, 38, 39},
				          {40, 41, 42, 43, 44, 45, 46, 47},
				          {48, 49, 50, 51, 52, 53, 54, 55},
				          {56, 57, 58, 59, 60, 61, 62, 63}};
		int[][] snailConstruction = {{ 0,  1,  2,  3,  4,  5,  6,  7, 15, 23, 31, 39, 47, 55, 63, 62, 61, 60, 59, 58, 57, 56, 48, 40, 32, 24, 16,  8},
				                     { 9, 10, 11, 12, 13, 14, 22, 30, 38, 46, 54, 53, 52, 51, 50, 49, 41, 33, 25, 17},
				                     {18, 19, 20, 21, 29, 37, 45, 44, 43, 42, 34, 26},
				                     {27, 28, 36, 35}};
		assertArrayEquals(snailConstruction, Matrix.toSnail(matrix));
	}
	
	@Test
	public void testFromSnail1() {
		
		int[][] snailConstruction1 = {{0}};
		int[][] expectedFromSnail = {{0}};
		assertArrayEquals(expectedFromSnail, Matrix.fromSnail(snailConstruction1));
		
		
		int[][] snailConstruction2 = {{0, 1, 3, 2}};
		int[][] expectedFromSnail2 = {{0, 1}, 
			                          {2, 3}};
		assertArrayEquals(expectedFromSnail2, Matrix.fromSnail(snailConstruction2));
	}
	
	@Test
	public void testFromSnail2() {
		
		int[][] snailConstruction1 = {{0, 1, 2, 5, 8, 7, 6, 3},
                                      {4}};
		int[][] expectedFromSnail1 = {{0, 1, 2},
			                          {3, 4, 5},
		                              {6, 7, 8}};
		
		assertArrayEquals(expectedFromSnail1, Matrix.fromSnail(snailConstruction1));
		
		
		int[][] snailConstruction2 = {{ 0,  1,  2,  3,  7, 11, 15, 14, 13, 12,  8,  4},
                                      { 5,  6, 10,  9}};
		int[][] expectedFromSnail2 = {{ 0,  1,  2,  3},
				                      { 4,  5,  6,  7},
				                      { 8,  9, 10, 11},
				                      {12, 13, 14, 15}};
		assertArrayEquals(expectedFromSnail2, Matrix.fromSnail(snailConstruction2));
	}
	
	@Test
	public void testFromSnail3() {
		
		int[][] snailConstruction = {{ 0,  1,  2,  3,  4,  5,  6,  7, 15, 23, 31, 39, 47, 55, 63, 62, 61, 60, 59, 58, 57, 56, 48, 40, 32, 24, 16,  8},
	                                 { 9, 10, 11, 12, 13, 14, 22, 30, 38, 46, 54, 53, 52, 51, 50, 49, 41, 33, 25, 17},
	                                 {18, 19, 20, 21, 29, 37, 45, 44, 43, 42, 34, 26},
	                                 {27, 28, 36, 35}};
		
		int[][] matrix = {{ 0,  1,  2,  3,  4,  5,  6,  7},
				          { 8,  9, 10, 11, 12, 13, 14, 15},
				          {16, 17, 18, 19, 20, 21, 22, 23},
			              {24, 25, 26, 27, 28, 29, 30, 31},
				          {32, 33, 34, 35, 36, 37, 38, 39},
				          {40, 41, 42, 43, 44, 45, 46, 47},
				          {48, 49, 50, 51, 52, 53, 54, 55},
				          {56, 57, 58, 59, 60, 61, 62, 63}};

		assertArrayEquals(matrix, Matrix.fromSnail(snailConstruction));
	}
	
	@Test
	public void testAreRowsPositive1() {
		
		int[][] snailConstruction1 = {{  1,   2,   3,   6,   9,   8,   7,   4}, {-10}};
		assertEquals(false, Matrix.areRowsPositive(snailConstruction1));
		
		int[][] snailConstruction2 = {{  1,   2,   3,   6,   9,   8,   7,   4}, {-9}};
		assertEquals(true, Matrix.areRowsPositive(snailConstruction2));
		
		int[][] snailConstruction3 = {{  1,   2,   3,   6,   9,   8, -16,   4}, {  5}};
		assertEquals(true, Matrix.areRowsPositive(snailConstruction3));
		
		int[][] snailConstruction4 = {{  1,   2,   3,   6,   9,   8, -17,   4}, {  5}};
		assertEquals(false, Matrix.areRowsPositive(snailConstruction4));
	}
	
	@Test
	public void testAreRingsDense1() {
		
		int[][] matrix1 = {{1,2,0},{0,-10,6},{7,0,9}};
		assertEquals(false, Matrix.areRingsDense(matrix1));
		
		int[][] matrix2 = {{1,2,0},{9,-10,6},{7,0,9}};
		assertEquals(true, Matrix.areRingsDense(matrix2));
		
		int[][] matrix3 = {{1,2,0},{9,0,6},{7,0,9}};
		assertEquals(false, Matrix.areRingsDense(matrix3));
		
		int[][] matrix4 = {{1,0,0},{4,-10,6},{7,8,9}};
		assertEquals(true, Matrix.areRingsDense(matrix4));
	}
}
