import org.junit.Test;
<<<<<<< HEAD

import javax.swing.event.InternalFrameListener;

=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
import static org.junit.Assert.*;

public class SLListTest {

    @Test
    public void testSLListAdd() {
        SLList test1 = SLList.of(1, 3, 5);
        SLList test2 = new SLList();

        test1.add(1, 2);
        test1.add(3, 4);
        assertEquals(5, test1.size());
        assertEquals(3, test1.get(2));
        assertEquals(4, test1.get(3));

        test2.add(1, 1);
        assertEquals(1, test2.get(0));
        assertEquals(1, test2.size());

        test2.add(10, 10);
        assertEquals(10, test2.get(1));
        test1.add(0, 0);
        assertEquals(SLList.of(0, 1, 2, 3, 4, 5), test1);
    }
<<<<<<< HEAD

    @Test
    public void testSLListReverse() {
        SLList test1 = SLList.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        SLList test2 = SLList.of(3, 1, 4, 1, 5, 9);

        test1.reverse();
        test2.reverse();
        assertEquals(9, test1.get(0));
        assertEquals(1, test1.get(8));
        assertEquals(5, test2.get(1));
        assertEquals(1, test2.get(4));
        test2.reverse();
        assertEquals(4, test2.get(2));

        SLList test3 = SLList.of(1);
        test3.reverse();
        assertEquals(1, test3.get(0));

        SLList test4 = SLList.of();
        test4.reverse();
        assertEquals(SLList.of(), test4);
    }

=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
}
