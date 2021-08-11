package deque;

import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

<<<<<<< HEAD
    /**
     * You MUST use the variable below for all of your tests. If you test
=======
    /** You MUST use the variable below for all of your tests. If you test
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
<<<<<<< HEAD
     * not grade that test.
     */

    //public static Deque<Integer> ad = new ArrayDeque<Integer>();
    ArrayDeque<Integer> arr = new ArrayDeque<Integer>();

    @Test
    public void addIsEmptySizeTest() {
        assertTrue("A newly initialized LLDeque should be empty", arr.isEmpty());
        arr.addFirst(0);
        assertFalse("lld should now contain 1 item", arr.isEmpty());
    }

    @Test
    public void Test_isEmpty() {
        ArrayDeque<Integer> arr1 = new ArrayDeque<Integer>();
        assertTrue("Linked List is not Empty", arr1.isEmpty());
    }

    @Test
    public void Test_addFirst() {
        ArrayDeque<Integer> arr2 = new ArrayDeque<Integer>();
        assertTrue("Linked List is not Empty", arr2.isEmpty());
        arr2.addFirst(4);
        arr2.addFirst(5);
        assertEquals(5, (int) arr2.get(0));
        assertEquals(4, (int) arr2.get(1));
    }

    @Test
    public void Test_addLast() {
        ArrayDeque<Integer> arr3 = new ArrayDeque<Integer>();
        arr3.addFirst(2);
        arr3.addFirst(1);
        arr3.addFirst(0);
        arr3.addLast(3);
        arr3.addLast(4);
        assertEquals(2, (int) arr3.get(2));
        assertEquals(3, (int) arr3.get(3));
        assertEquals(4, (int) arr3.get(4));
        assertEquals(null, arr3.get(9));
    }

    @Test
    public void Test_printDeque() {
        ArrayDeque<Integer> arr4 = new ArrayDeque<Integer>();
        arr4.addFirst(6);
        arr4.addFirst(5);
        arr4.addFirst(4);
        arr4.addLast(7);
        arr4.addLast(8);
        arr4.printDeque();
    }

    @Test
    public void Test_addcombo() {
        ArrayDeque<Integer> arr5 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                arr5.addFirst(i);
            } else {
                arr5.addLast(i);
            }
        }
        assertEquals(8, (int) arr5.get(0));
        assertEquals(0, (int) arr5.get(4));
        assertEquals(7, (int) arr5.get(8));
    }

    @Test
    public void Test_string() {
        ArrayDeque<String> arr6 = new ArrayDeque<String>();
        arr6.addFirst("hello");
        arr6.addLast("how");
        arr6.addLast("r");
        arr6.addLast("u");
        arr6.addLast("?");
        assertEquals(5, arr6.size());
        assertEquals("r", arr6.get(2));
        assertEquals("u", arr6.get(3));
        assertEquals(null, arr6.get(-1));
        arr6.printDeque();
    }

    @Test
    public void Test_removeFirst() {
        ArrayDeque<Integer> arr7 = new ArrayDeque<Integer>();
        assertEquals(null, arr7.removeFirst());
        arr7.addFirst(4);
        arr7.addFirst(2);
        arr7.addFirst(0);
        arr7.addLast(6);
        assertEquals(0, (int) arr7.removeFirst());
        assertEquals(2, (int) arr7.get(0));
        assertEquals(3, (int) arr7.size());
        arr7.printDeque();
    }

    @Test
    public void Test_removelast() {
        ArrayDeque<Integer> arr8 = new ArrayDeque<Integer>();
        assertEquals(null, arr8.removeFirst());
        arr8.addFirst(5);
        arr8.addFirst(3);
        arr8.addFirst(1);
        arr8.addLast(7);
        assertEquals(7, (int) arr8.removeLast());
        assertEquals(5, (int) arr8.get(2));
        assertEquals(3, (int) arr8.size());
        arr8.printDeque();
    }

    @Test
    public void Test_equals() {
        ArrayDeque<Integer> arr9 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> arr10 = new ArrayDeque<Integer>();
        assertTrue(" ", arr10.equals(arr9));
        arr9.addFirst(10);
        arr10.addFirst(9);
        arr10.addFirst(10);
        arr9.printDeque();
        arr10.printDeque();
        assertFalse(" ", arr10.equals(arr9));
    }

    @Test
    public void Test_equals2() {
        ArrayDeque<String> arr11 = new ArrayDeque<String>();
        ArrayDeque<String> arr12 = new ArrayDeque<String>();
        arr11.addFirst("hello");
        arr12.addFirst("hello");
        assertTrue(" ", arr11.equals(arr12));
        assertFalse(" ", arr11.isEmpty());
    }

    @Test
    public void Test_addcombo2() {
        ArrayDeque<Integer> arr13 = new ArrayDeque<Integer>();
        arr13.addFirst(4);
        arr13.addFirst(3);
        arr13.addFirst(2);
        arr13.addFirst(1);
        arr13.addFirst(0);
        assertEquals(0, (int) arr13.get(0));
        assertEquals(2, (int) arr13.get(2));
        arr13.addLast(5);
        arr13.addLast(6);
        assertEquals(7, (int) arr13.size());
        arr13.removeFirst();
        arr13.removeLast();
        assertEquals(1, (int) arr13.get(0));
        assertEquals(null, arr13.get(10));
        assertEquals(5, (int) arr13.size());
    }

    @Test
    public void Test_equals4() {
        LinkedListDeque<String> lld11 = new LinkedListDeque<String>();
        ArrayDeque<String> arr11 = new ArrayDeque<String>();
        lld11.addFirst("honey");
        lld11.addFirst("hello");
        arr11.addFirst("hello");
        arr11.addFirst("hi");
        assertFalse(" ", lld11.equals(arr11));
    }

    @Test
    public void Test_equals5() {
        LinkedListDeque<String> lld11 = new LinkedListDeque<String>();
        ArrayDeque<String> arr11 = new ArrayDeque<String>();

    }
=======
     * not grade that test. */

    //public static Deque<Integer> ad = new ArrayDequeTest<Integer>();
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

}
