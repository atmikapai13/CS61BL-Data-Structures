package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

<<<<<<< HEAD
    public static Deque<Integer> lld = new LinkedListDeque<Integer>();
=======
    //public static Deque<Integer> lld = new LinkedListDeque<Integer>();
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
<<<<<<< HEAD
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);
        assertFalse("lld should now contain 1 item", lld.isEmpty());
    }

    @Test
    public void Test_isEmpty() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        assertTrue("Linked List is not Empty", lld1.isEmpty());
    }

    @Test
    public void Test_addFirst() {
        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        assertTrue("Linked List is not Empty", lld2.isEmpty());
        lld2.addFirst(4);
        lld2.addFirst(5);
        assertEquals(5, (int) lld2.get(0));
        assertEquals(4, (int) lld2.get(1));
    }

    @Test
    public void Test_addLast() {
        LinkedListDeque<Integer> lld3 = new LinkedListDeque<Integer>();
        lld3.addFirst(2);
        lld3.addFirst(1);
        lld3.addFirst(0);
        lld3.addLast(3);
        lld3.addLast(4);
        assertEquals(2, (int) lld3.get(2));
        assertEquals(3, (int) lld3.get(3));
        assertEquals(4, (int) lld3.get(4));
        assertEquals(4, (int) lld3.getRecursive(4));
        assertEquals(null, lld3.get(9));
    }

    @Test
    public void Test_printDeque() {
        LinkedListDeque<Integer> lld4 = new LinkedListDeque<Integer>();
        lld4.addFirst(6);
        lld4.addFirst(5);
        lld4.addFirst(4);
        lld4.addLast(7);
        lld4.addLast(8);
        lld4.printDeque();
    }

    @Test
    public void Test_addcombo() {
        LinkedListDeque<Integer> lld5 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                lld5.addFirst(i);
            } else {
                lld5.addLast(i);
            }
        }
        assertEquals(8, (int) lld5.get(0));
        assertEquals(0, (int) lld5.get(4));
        assertEquals(7, (int) lld5.get(8));
    }

    @Test
    public void Test_string() {
        LinkedListDeque<String> lld6 = new LinkedListDeque<String>();
        lld6.addFirst("hello");
        lld6.addLast("how");
        lld6.addLast("r");
        lld6.addLast("u");
        lld6.addLast("?");
        assertEquals(5, lld6.size());
        assertEquals("r", lld6.getRecursive(2));
        assertEquals("u", lld6.getRecursive(3));
        assertEquals(null, lld6.getRecursive(-1));
        lld6.printDeque();
    }

    @Test
    public void Test_removeFirst() {
        LinkedListDeque<Integer> lld7 = new LinkedListDeque<Integer>();
        assertEquals(null, lld7.removeFirst());
        lld7.addFirst(4);
        lld7.addFirst(2);
        lld7.addFirst(0);
        lld7.addLast(6);
        assertEquals(0, (int) lld7.removeFirst());
        assertEquals(2, (int) lld7.get(0));
        assertEquals(3, (int) lld7.size());
        lld7.printDeque();
    }

    @Test
    public void Test_removelast() {
        LinkedListDeque<Integer> lld8 = new LinkedListDeque<Integer>();
        assertEquals(null, lld8.removeFirst());
        lld8.addFirst(5);
        lld8.addFirst(3);
        lld8.addFirst(1);
        lld8.addLast(7);
        assertEquals(7, (int) lld8.removeLast());
        assertEquals(5, (int) lld8.get(2));
        assertEquals(3, (int) lld8.size());
        lld8.printDeque();
    }

    @Test
    public void Test_equals() {
        LinkedListDeque<Integer> lld9 = new LinkedListDeque<Integer>();
        LinkedListDeque<Integer> lld10 = new LinkedListDeque<Integer>();
        assertTrue(" ", lld10.equals(lld9));
        lld9.addFirst(10);
        lld10.addFirst(9);
        lld10.addFirst(10);
        lld9.printDeque();
        lld10.printDeque();
        assertFalse(" ", lld10.equals(lld9));
    }

    @Test
    public void Test_equals2() {
        LinkedListDeque<String> lld11 = new LinkedListDeque<String>();
        LinkedListDeque<String> lld12 = new LinkedListDeque<String>();
        lld11.addFirst("hello");
        lld12.addFirst("hello");
        assertTrue(" ", lld11.equals(lld12));
        assertFalse(" ", lld11.isEmpty());
    }

    @Test
    public void Test_equals3() {
        LinkedListDeque<String> lld11 = new LinkedListDeque<String>();
        ArrayDeque<String> arr12 = new ArrayDeque<String>();
        lld11.addFirst("hello");
        arr12.addFirst("hello");
        assertTrue(" ", lld11.equals(arr12));
    }

    @Test
    public void Test_equals4() {
        LinkedListDeque<String> lld11 = new LinkedListDeque<String>();
        ArrayDeque<String> arr12 = new ArrayDeque<String>();
        lld11.addFirst("hello");
        arr12.addFirst("hi");
        arr12.addFirst("hello");
        assertFalse(" ", lld11.equals(arr12));
=======

        System.out.println("Make sure to uncomment the lines below (and delete this print statement)." +
                " The code you submit to the AG shouldn't have any print statements!");
        /*

		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);

        assertFalse("lld should now contain 1 item", lld.isEmpty());

        // Reset the linked list deque at the END of the test.
        lld = new LinkedListDeque<Integer>();
		*/
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

}
