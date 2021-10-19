import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class Max3Test {

	@Test
	public void testMax3Examples() {
		
		assertArrayEquals(new int[] {3, 4, 5}, Max3.max3(new int[] {1, 2, 3, 4, 5}));
		assertArrayEquals(new int[] {3, 4, 5}, Max3.max3(new int[] {4, 2, 1, 5, 3}));
		assertArrayEquals(new int[] {4, 5, 5}, Max3.max3(new int[] {5, 4, 1, 5, 3}));
		assertArrayEquals(new int[] {1, 2, 20}, Max3.max3(new int[] {2, 1, 20}));
		assertArrayEquals(new int[] {1, 3, 4}, Max3.max3(new int[] {1, 4, -2, 3}));
	}
}
