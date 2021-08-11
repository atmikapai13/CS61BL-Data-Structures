import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

/**
 * Created by Jenny Huang on 3/12/19.
 */
public class TestMyTrieSet {

    // assumes add/contains work
    @Test
    public void sanityClearTest() {
<<<<<<< HEAD
        MyTrieSet t = new MyTrieSet();
        for (int i = 0; i < 455; i++) {
            t.add("hi" + i);
            //make sure put is working via contains
            assertTrue(t.contains("hi" + i));
        }
        t.clear();
        for (int i = 0; i < 455; i++) {
            assertFalse(t.contains("hi" + i));
        }
=======
        // MyTrieSet t = new MyTrieSet();
        // for (int i = 0; i < 455; i++) {
        //     t.add("hi" + i);
        //     //make sure put is working via contains
        //     assertTrue(t.contains("hi" + i));
        // }
        // t.clear();
        // for (int i = 0; i < 455; i++) {
        //     assertFalse(t.contains("hi" + i));
        // }
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    // assumes add works
    @Test
    public void sanityContainsTest() {
<<<<<<< HEAD
        MyTrieSet t = new MyTrieSet();
        assertFalse(t.contains("waterYouDoingHere"));
        t.add("waterYouDoingHere");
        assertTrue(t.contains("waterYouDoingHere"));
        assertFalse(t.contains("waterYouDoing"));
=======
        // MyTrieSet t = new MyTrieSet();
        // assertFalse(t.contains("waterYouDoingHere"));
        // t.add("waterYouDoingHere");
        // assertTrue(t.contains("waterYouDoingHere"));
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    // assumes add works
    @Test
    public void sanityPrefixTest() {
<<<<<<< HEAD
        String[] saStrings = new String[]{"same", "sam", "sad", "sap"};
        String[] otherStrings = new String[]{"a", "awls", "hello"};

        MyTrieSet t = new MyTrieSet();
        for (String s: saStrings) {
            t.add(s);
        }
        for (String s: otherStrings) {
            t.add(s);
        }

        List<String> keys = t.keysWithPrefix("sa");
        for (String s: saStrings) {
            assertTrue(keys.contains(s));
        }
        for (String s: otherStrings) {
            assertFalse(keys.contains(s));
        }
=======
        // String[] saStrings = new String[]{"same", "sam", "sad", "sap"};
        // String[] otherStrings = new String[]{"a", "awls", "hello"};

        // MyTrieSet t = new MyTrieSet();
        // for (String s: saStrings) {
        //     t.add(s);
        // }
        // for (String s: otherStrings) {
        //     t.add(s);
        // }

        // List<String> keys = t.keysWithPrefix("sa");
        // for (String s: saStrings) {
        //     assertTrue(keys.contains(s));
        // }
        // for (String s: otherStrings) {
        //     assertFalse(keys.contains(s));
        // }
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }
}
