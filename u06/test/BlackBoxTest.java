import static org.junit.Assert.*;

import org.junit.Test;

public class BlackBoxTest {

	@Test
	public void testRotateArray() {
	    int[] values = new int[] { 1, 2 };
		int[] expected = new int[] { 2, 1 };
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);
	}
}
