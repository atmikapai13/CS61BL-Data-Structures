import org.junit.Test;
import static org.junit.Assert.*;

public class CodingChallengesTest {

    @Test
    public void testisPermutation() {
        String s1 = "superintendant";
        String s2 = "pinnaetdnusret";
        Boolean a = CodingChallenges.isPermutation(s1, s2);
        assertEquals(true, a);
        assertEquals(true, CodingChallenges.isPermutation("act", "cat"));
        assertEquals(true, CodingChallenges.isPermutation("cat", "act"));
        assertEquals(true, CodingChallenges.isPermutation("tac", "cat"));
        assertEquals(true, CodingChallenges.isPermutation("atc", "cat"));
        assertEquals(false, CodingChallenges.isPermutation("atcc", "act"));
    }
}