import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.rules.Timeout;
import org.junit.Rule;
import org.junit.Test;

public class FlexArrayTest {
	
	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);
	
	@Test
	public void testBasic1() {
		FlexArray fa;
        
        int[] starts = {-15, -5, 0, 5 };
        // reference result array of length 10
        int[] ref = new int[10];
        for (int i=0; i<ref.length; i++) {
            ref[i] = i;
        }
        
        // always try arrays with length 10
        for (int k = 0; k< starts.length; k++) {
            
            fa = new FlexArray(10, starts[k]);

            // can we write each element?
            for (int i=0; i<10; i++) {
                fa.write(i+starts[k], i);
            }
            
            assertArrayEquals(ref, fa.rawArray());

            // try reads
            int[] tmp = new int[10];
            for (int i=0; i<10; i++) {
                tmp[i] = fa.read(i+starts[k]);
            }
            assertArrayEquals(tmp, fa.rawArray());
            
            int out1 = fa.read(starts[k]-1);
            assertEquals(Integer.MIN_VALUE, out1);

            int out2 = fa.read(starts[k]+11);
            assertEquals(Integer.MIN_VALUE, out2);

            // check that rawArray returns a fresh copy
            int[] data = fa.rawArray();
            fa.write(starts[k], 42);
            assertFalse(Arrays.equals(fa.rawArray(), data));
            fa.write(starts[k],0);

            FlexArray ga = fa.copy();
            assertTrue(ga.equals(fa));
            assertTrue(fa.equals(ga));

            ga.write(starts[k], 42);
            assertFalse(ga.equals(fa));
            assertFalse(fa.equals(ga));
            
            // try new array with 20 elements, first 10 identical to fa
            ga = new FlexArray(20, starts[k]);
            for (int i=0; i<10; i++) {
                ga.write(i+starts[k], i);
            }
            assertFalse(ga.equals(fa));
            assertFalse(fa.equals(ga));          

            // try new array with 10 elements but different start
            ga = new FlexArray(10, starts[k]-1);
            for (int i=0; i<10; i++) {
                ga.write(i+starts[k]-1, i);
            }
            assertFalse(ga.equals(fa));
            assertFalse(fa.equals(ga));
            
            ga = new FlexArray(10, starts[k]+1);
            for (int i=0; i<10; i++) {
                ga.write(i+starts[k]+1, i);
            }
            assertFalse(ga.equals(fa));
            assertFalse(fa.equals(ga));           
        }
	}
	
	@Test
	public void testNull() {
		FlexArray fa;
        fa = new FlexArray();
        
        assertEquals(Integer.MIN_VALUE, fa.read(0));
        assertEquals(Integer.MIN_VALUE, fa.read(1));
	}
	
	@Test
	public void testMerge1() {
		FlexArray fa;
        FlexArray ga;
        FlexArray r;
        int[] ra;

        // 4 sample tests for merge
        fa = new FlexArray(10, -12);
        for (int i=0; i<10; i++) {
            fa.write(i-12, i);
        }
        ga = new FlexArray(4, -8);
        for (int i=0; i<4; i++) {
            ga.write(i-8, 100 + 100*i);
        }
        r = fa.merge(ga);
        ra = r.rawArray();
        int[] expected1 = {0, 1, 2, 3, 104, 205, 306, 407, 8, 9};
        assertArrayEquals(expected1, ra);

        fa = new FlexArray(10, -12);
        for (int i=0; i<10; i++) {
            fa.write(i-12, i);
        }
        ga = new FlexArray(4, 0);
        for (int i=0; i<4; i++) {
            ga.write(i+0, 100 + 100*i);
        }
        r = fa.merge(ga);
        assertEquals(null, r);

        fa = new FlexArray(10, -5);
        for (int i=0; i<10; i++) {
            fa.write(i-5, i);
        }
        ga = new FlexArray(4, 0);
        for (int i=0; i<4; i++) {
            ga.write(i, 100 + 100*i);
        }
        r = fa.merge(ga);
        ra = r.rawArray();
        int[] expected2 = {0, 1, 2, 3, 4, 105, 206, 307, 408, 9};
        assertArrayEquals(expected2, ra);

        fa = new FlexArray(10, 5);
        for (int i=0; i<10; i++) {
            fa.write(i+5, i);
        }
        ga = new FlexArray(4, 7);
        for (int i=0; i<4; i++) {
            ga.write(i+7, 100 + 100*i);
        }
        r = fa.merge(ga);
        ra = r.rawArray();
        int[] expected3 = {0, 1, 102, 203, 304, 405, 6, 7, 8, 9};
        assertArrayEquals(expected3, ra);
	}
}
