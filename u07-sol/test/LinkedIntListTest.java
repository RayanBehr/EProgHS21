import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class LinkedIntListTest {

	public LinkedIntList arrayToList(int[] elems) {
		LinkedIntList res = new LinkedIntList();

		if (elems.length == 1) {
			res.first = res.last = new IntNode(elems[0]);
			res.size = 1;
		} else if (elems.length > 1) {
			IntNode newNode = new IntNode(elems[0]);
			res.first = newNode;

			for (int i = 1; i < elems.length; i++) {
				newNode.next = new IntNode(elems[i]);
				newNode = newNode.next;
			}
			res.last = newNode;
			res.size = elems.length;
		}

		return res;
	}

	public void assertConsistency(LinkedIntList ll) {
		assertEquals(ll.first == null, ll.last == null);
		assertEquals(ll.first == null, ll.isEmpty());
		assertEquals(ll.first == null, ll.size == 0);

		if (!ll.isEmpty())
			assertTrue(ll.last.next == null);
		
		int count = 0;
		for (IntNode n = ll.first; n != null; n = n.next) {
			count++;
			if (n.next == null)
				assertTrue(n == ll.last);
		}
		
		assertEquals(count, ll.size);
	}
    
    @Test
    public void testRandom() {
        Random rand = new Random(42);
        LinkedIntList ll = new LinkedIntList();
        for(int n = 0; n < 9721; n++) {
            int choice = rand.nextInt(6);
            int value = rand.nextInt();
            
            if(choice == 0)
                ll.addFirst(value);
            else if(choice == 1)
                ll.addLast(value);
            else if(choice == 2 && !ll.isEmpty())
                ll.removeFirst();
            else if(choice == 3 && !ll.isEmpty())
                ll.removeLast();
            else if(choice == 4 && !ll.isEmpty())
                ll.set(rand.nextInt(ll.size), value);
            else if(choice == 5 && value % 5 == 0)
                ll.clear();
        }
//        IntNode cur = ll.getNode(0);
//        do{
//        	System.out.println(cur.value);
//        	cur=cur.next;
//        }while(cur!=null&&cur!=null);
        
        String msg = "There is a bug in your LinkedIntList";
        assertFalse(msg, ll.isEmpty());
        assertEquals(msg, 5, ll.size);
        int[] expect = new int[]{-1759285598, -424345731,
                -1746103561, -1623993329, -1831395423};
        assertArrayEquals(msg, expect, ll.toArray());
    }
    
	int[] one = { 42 };
	int[] two = { 3, 1 };
	int[] three = { 2, 7, 1 };

	@Test
	public void testGet() {
		assertEquals(42, arrayToList(one).get(0));

		LinkedIntList ll = arrayToList(two);
		assertEquals(3, ll.get(0));
		assertEquals(1, ll.get(1));

		ll = arrayToList(three);
		assertEquals(2, ll.get(0));
		assertEquals(7, ll.get(1));
		assertEquals(1, ll.get(2));
		assertEquals(3, ll.size);
	}

	@Test
	public void testSet() {
		LinkedIntList ll = arrayToList(one);
		ll.set(0, 11);
		assertEquals(11, ll.get(0));

		ll = arrayToList(two);
		ll.set(1, 11);
		assertArrayEquals(new int[] { 3, 11 }, ll.toArray());
		ll.set(0, 12);
		assertArrayEquals(new int[] { 12, 11 }, ll.toArray());

		ll = arrayToList(three);
		ll.set(0, 0);
		ll.set(1, 1);
		ll.set(2, 2);
		assertArrayEquals(new int[] { 0, 1, 2 }, ll.toArray());
		assertEquals(3, ll.size);

	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, new LinkedIntList().isEmpty());
		assertEquals(false, arrayToList(one).isEmpty());
		assertEquals(false, arrayToList(three).isEmpty());
	}

	@Test
	public void testAddFirst() {
		LinkedIntList ll = new LinkedIntList();
		ll.addFirst(11);
		assertEquals(11, ll.get(0));
		assertEquals(1, ll.size);
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.addFirst(11);
		assertArrayEquals(new int[] { 11, 42 }, ll.toArray());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		ll.addFirst(12);
		assertArrayEquals(new int[] { 12, 11, 42 }, ll.toArray());
		assertEquals(3, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testAddLast() {
		LinkedIntList ll = new LinkedIntList();
		ll.addLast(11);
		assertEquals(11, ll.get(0));
		assertEquals(1, ll.size);
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.addLast(11);
		assertArrayEquals(new int[] { 42, 11 }, ll.toArray());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		ll.addLast(12);
		assertArrayEquals(new int[] { 42, 11, 12 }, ll.toArray());
		assertEquals(3, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testRemoveFirst() {
		LinkedIntList ll = arrayToList(one);
		assertEquals(42, ll.removeFirst());
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(three);
		assertEquals(2, ll.removeFirst());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		assertEquals(7, ll.removeFirst());
		assertEquals(1, ll.size);
		assertConsistency(ll);
		assertEquals(1, ll.removeFirst());
		assertEquals(0, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testRemoveLast() {
		LinkedIntList ll = arrayToList(one);
		assertEquals(42, ll.removeLast());
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(three);
		assertEquals(1, ll.removeLast());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		assertEquals(7, ll.removeLast());
		assertEquals(1, ll.size);
		assertConsistency(ll);
		assertEquals(2, ll.removeLast());
		assertEquals(0, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testClear() {
		LinkedIntList ll = new LinkedIntList();
		ll.clear();
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.clear();
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(two);
		ll.clear();
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(three);
		ll.clear();
		assertEquals(0, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testToArray() {
		LinkedIntList ll = new LinkedIntList();
		assertArrayEquals(new int[]{}, ll.toArray());
		assertArrayEquals(one, arrayToList(one).toArray());
		assertArrayEquals(two, arrayToList(two).toArray());
		assertArrayEquals(three, arrayToList(three).toArray());
	}

}
