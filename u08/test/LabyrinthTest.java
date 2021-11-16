import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LabyrinthTest {

	@Test
	public void testTask1Small() {
		
		Room ex0 = createDenseLabyrinth(new int[][] {{3},{1}});
		assertEquals(false, Labyrinth.task1(ex0));
		
		Room ex1 = createDenseLabyrinth(new int[][] {{2},{1}});
		assertEquals(false, Labyrinth.task1(ex1));
		
		Room ex2 = createDenseLabyrinth(new int[][] {{2},{1,3}});
		assertEquals(true, Labyrinth.task1(ex2));
		
		Room ex3 = createDenseLabyrinth(new int[][] {{2},{1,3,4},{3,3,3},{1,12,9}});
		assertEquals(true, Labyrinth.task1(ex3));
	}
	
	@Test
	public void testTask1Big() {
		
		int n = 100; 
		int[][] plan1 = new int[n][n];
		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < n; j += 1) {
				plan1[i][j] = 1 + i + j;
			}
		}
		
		Room ex1 = createDenseLabyrinth(plan1);
		assertEquals(true, Labyrinth.task1(ex1));
		
		
		n = 8;
		int[][] plan2 = new int[n][n];
		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < n; j += 1) {
				if (i == 0) { plan2[i][j] = 1; }
				else if (i == n-1) { plan2[i][j] = 2; } 
				else { plan2[i][j] = 3 * i + 3 * j; }
			}
		}
		Room ex2 = createDenseLabyrinth(plan2);
		assertEquals(false, Labyrinth.task1(ex2));
		
	}
	
	@Test
	public void testTask2Small() {
		
		Room ex0 = createDenseLabyrinth(new int[][] {{1},{2},{3},{4},{5}});
		assertEquals(false, Labyrinth.task2(ex0));
		
		Room ex1 = createDenseLabyrinth(new int[][] {{1},{2},{3, 3},{4},{5}});
		assertEquals(true, Labyrinth.task2(ex1));
		
		Room ex2 = createDenseLabyrinth(new int[][] {{1},{2},{3, 4},{4},{5}});
		assertEquals(false, Labyrinth.task2(ex2));
		
		Room ex3 = createDenseLabyrinth(new int[][] {{1},{2,2},{3,3},{4,4},{5,5}});
		assertEquals(true, Labyrinth.task2(ex3));
	}
	
	@Test
	public void testTask2Big() {
		
		int n = 100; 
		int[][] plan1 = new int[n][n];
		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < n; j += 1) {
				plan1[i][j] = i;
			}
		}
		
		Room ex1 = createDenseLabyrinth(plan1);
		assertEquals(true, Labyrinth.task2(ex1));
	}
	
	
	/* 
	 * Eine Hilfsfunktion, welche Labyrinthe erstellt. 
	 * Es gibt genau einen Raum für jeden Eintrag in `plan`.
	 * `matrix[i][j]` enthaelt das Alter vom entsprechenden Raum.
	 * Der Raum fuer `matrix[i][j]` hat Tueren zu `matrix[i+1][k]` fuer jedes k mit 0 <= k < matrix[i+1].length.
	 * 
	 * */
	static Room createDenseLabyrinth(int[][] plan) {
		Room[] nexts = new Room[0];
		
		for (int i = plan.length-1; i >= 0; i -= 1) {
			Room[] rooms = new Room[plan[i].length];
			for (int j = 0; j < plan[i].length; j += 1) {
				rooms[j] = new Room(plan[i][j], Arrays.copyOf(nexts, nexts.length));
			}
			nexts = rooms;
		}
		
		if (nexts.length > 0) { return nexts[0]; }
		else { return null; }
	}
}
