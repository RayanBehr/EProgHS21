import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedPersonListTest {

	public LinkedPersonList arrayToList(Person[] elems) {
		LinkedPersonList res = new LinkedPersonList();

		if (elems.length == 1) {
			res.first = res.last = new PersonNode(elems[0]);
			res.size = 1;
		} else if (elems.length > 1) {
			PersonNode newNode = new PersonNode(elems[0]);
			res.first = newNode;

			for (int i = 1; i < elems.length; i++) {
				newNode.next = new PersonNode(elems[i]);
				newNode.next.prev = newNode;
				newNode = newNode.next;
			}
			res.last = newNode;
			res.size = elems.length;
		}
		assertConsistency(res);
		return res;
	}

	public void assertConsistency(LinkedPersonList ll) {
		assertEquals(ll.first == null, ll.last == null);
		assertEquals(ll.first == null, ll.isEmpty());
		assertEquals(ll.first == null, ll.size == 0);

		if (!ll.isEmpty()) {
			assertTrue(ll.first.prev == null);
			assertTrue(ll.last.next == null);
		}
		
		int count = 0;
		for (PersonNode n = ll.first; n != null; n = n.next) {
			count++;
			if (n.next != null) {
				assertTrue(n.next.prev == n);
			} else {
				assertTrue(n == ll.last);
			}
			
			if (n.prev != null) {
				assertTrue(n.prev.next == n);
			} else {
				assertTrue(n == ll.first);
			}
		}
		
		assertEquals(count, ll.size);
	}
    
    
	
	Person a = new Person(1);
	Person b = new Person(2);
	Person c = new Person(3);
	Person x = new Person(7);
	Person y = new Person(8);
	Person z = new Person(9);
	Person[] one = { a };
	Person[] two = { a, b };
	Person[] three = { a, b, c };

	@Test
	public void testGet() {
		assertEquals(a, arrayToList(one).get(0));

		LinkedPersonList ll = arrayToList(two);
		assertEquals(a, ll.get(0));
		assertEquals(b, ll.get(1));

		ll = arrayToList(three);
		assertEquals(a, ll.get(0));
		assertEquals(b, ll.get(1));
		assertEquals(c, ll.get(2));
		assertEquals(3, ll.size);
	}

	@Test
	public void testSet() {
		LinkedPersonList ll = arrayToList(one);
		ll.set(0, x);
		assertEquals(x, ll.get(0));

		ll = arrayToList(two);
		ll.set(1, x);
		assertArrayEquals(new Person[] { a, x }, ll.toArray());
		ll.set(0, y);
		assertArrayEquals(new Person[] { y, x }, ll.toArray());

		ll = arrayToList(three);
		ll.set(0, x);
		ll.set(1, y);
		ll.set(2, z);
		assertArrayEquals(new Person[] { x, y, z }, ll.toArray());
		assertEquals(3, ll.size);

	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, new LinkedPersonList().isEmpty());
		assertEquals(false, arrayToList(one).isEmpty());
		assertEquals(false, arrayToList(three).isEmpty());
	}

	@Test
	public void testAddFirst() {
		LinkedPersonList ll = new LinkedPersonList();
		ll.addFirst(x);
		assertEquals(x, ll.get(0));
		assertEquals(1, ll.size);
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.addFirst(x);
		assertArrayEquals(new Person[] { x, a }, ll.toArray());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		ll.addFirst(y);
		assertArrayEquals(new Person[] { y, x, a }, ll.toArray());
		assertEquals(3, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testAddLast() {
		LinkedPersonList ll = new LinkedPersonList();
		ll.addLast(x);
		assertEquals(x, ll.get(0));
		assertEquals(1, ll.size);
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.addLast(x);
		assertArrayEquals(new Person[] { a, x }, ll.toArray());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		ll.addLast(y);
		assertArrayEquals(new Person[] { a, x, y }, ll.toArray());
		assertEquals(3, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testRemoveFirst() {
		LinkedPersonList ll = arrayToList(one);
		assertEquals(a, ll.removeFirst());
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(three);
		assertEquals(a, ll.removeFirst());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		assertEquals(b, ll.removeFirst());
		assertEquals(1, ll.size);
		assertConsistency(ll);
		assertEquals(c, ll.removeFirst());
		assertEquals(0, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testRemoveLast() {
		LinkedPersonList ll = arrayToList(one);
		assertEquals(a, ll.removeLast());
		assertEquals(0, ll.size);
		assertConsistency(ll);

		ll = arrayToList(three);
		assertEquals(c, ll.removeLast());
		assertEquals(2, ll.size);
		assertConsistency(ll);
		assertEquals(b, ll.removeLast());
		assertEquals(1, ll.size);
		assertConsistency(ll);
		assertEquals(a, ll.removeLast());
		assertEquals(0, ll.size);
		assertConsistency(ll);
	}

	@Test
	public void testRemoveNode() {
		LinkedPersonList ll = arrayToList(one);
		ll.removeNode(ll.first);
		assertEquals(0, ll.size);
		assertConsistency(ll);
		
		ll = arrayToList(three);
		ll.removeNode(ll.first.next);
		assertEquals(2, ll.size);
		assertArrayEquals(new Person[] { a, c }, ll.toArray());
		assertConsistency(ll);
		
		ll.removeNode(ll.last);
		assertEquals(1, ll.size);
		assertArrayEquals(new Person[] { a }, ll.toArray());
		assertConsistency(ll);
	}
	
	@Test
	public void testClear() {
		LinkedPersonList ll = new LinkedPersonList();
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
		LinkedPersonList ll = new LinkedPersonList();
		assertArrayEquals(new Person[]{}, ll.toArray());
		assertArrayEquals(one, arrayToList(one).toArray());
		assertArrayEquals(two, arrayToList(two).toArray());
		assertArrayEquals(three, arrayToList(three).toArray());
	}

}
