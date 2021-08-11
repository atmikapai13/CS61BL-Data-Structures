import static org.junit.Assert.*;
import org.junit.Test;



public class SimpleNameMapTest {

    @Test
    public void implementation1() {
        SimpleNameMap arr = new SimpleNameMap();
        arr.put("Abhishek", "Nev");
        arr.put("Brenda", "Huang");
        arr.put("Dexter", "To");
        arr.put("Zoe", "Plaxco");
        arr.put("Trippy", "Barbara");
        arr.put("Trop", "bobz");
        arr.put("skippy", "btransobz");
        arr.put("skggggippy", "btransobz");
        arr.put("sfkippy", "btranrrrsobz");
        arr.put("skgdksjfgggippy", "btransobz");
        arr.put("skggksfjdggippy", "btransobz");
        arr.put("skgggkjsdfjgippy", "btransobz");
        arr.put("skgggkjsdfsdkffjgippy", "btransobz");
        arr.put("jsdfsdkffjgippy", "btransobz");
        arr.put("py", "btransobz");
        arr.put("jkdsfpy", "btransobz");
        arr.put("jkfjsdfdsfpy", "btransobz");
        assertEquals("Plaxco", arr.get("Zoe"));
        //assertEquals(4, arr.size());
        //assertEquals("Plaxco", arr.remove("Zoe"));
        //assertEquals(3, arr.size());

        //assertEquals(true, arr.resize());
        assertEquals(20, arr.size());
    }
}
