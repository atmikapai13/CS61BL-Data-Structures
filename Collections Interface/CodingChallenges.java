<<<<<<< HEAD
import java.util.*;

import static java.lang.Math.max;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
<<<<<<< HEAD
        HashSet<Integer> orig = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            orig.add(values[i]); }
        for (int i = 0; i <= values.length; i++) {
            if (orig.contains(i) == false) {
                return i;
            }
        }
        return 0;
=======
        // TODO
        return -1;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /**
     * Returns true if and only if two integers in the array sum up to n.
     * Assume all values in the array are unique.
     */
    public static boolean sumTo(int[] values, int n) {
<<<<<<< HEAD
        HashSet<Integer> orig = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            orig.add(values[i]);
        }
        for (int i = 0; i < values.length; i++) {
            if (orig.contains(n - values[i])) {
                return true;
            }
        }
=======
        // TODO
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        return false;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
<<<<<<< HEAD
        char[] index1 = s1.toCharArray();
        Arrays.sort(index1);
        s1 = new String(index1);

        char[] index2 = s2.toCharArray();
        Arrays.sort(index2);
        s2 = new String(index2);

        if (s1.equals(s2)) {
            return true;
        }
        /*
        int i = 0;
        while (i <= s2.length() - s1. length()) {
            if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
                return true;
            }
            i++;
        }

         */
        return false;
    }

=======
        // TODO
        return false;
    }
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
}