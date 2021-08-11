/**
 * Represent a set of nonnegative ints from 0 to maxElement for some initially
 * specified maxElement.
 */
public class BooleanSet implements SimpleSet {

    private boolean[] contains;
    private int size;

    /** Initializes a set of ints from 0 to maxElement. */
    public BooleanSet(int maxElement) {
        contains = new boolean[maxElement + 1];
        size = 0;
    }

    /** Adds k to the set. */
    public void add(int k) {
<<<<<<< HEAD
        this.contains[k] = true;
=======
        // TODO
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /** Removes k from the set. */
    public void remove(int k) {
<<<<<<< HEAD
        this.contains[k] = false;
=======
        // TODO
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /** Return true if k is in this set, false otherwise. */
    public boolean contains(int k) {
        return contains[k];
    }

    /** Return true if this set is empty, false otherwise. */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /** Returns the number of items in the set. */
    public int size() {
<<<<<<< HEAD
        int i = 0;
        int total_size = 0;
        while (i <= contains.length - 1) {
            if (this.contains[i]) {
                total_size += 1;
            }
            i += 1;
        }
        return total_size;
=======
        //TODO
        return 0;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /** Returns an array containing all of the elements in this collection. */
    public int[] toIntArray() {
<<<<<<< HEAD
        int i = 0;
        int[] total_elements = new int[size()];
        int index = 0;
        while (i <= contains.length - 1) {
            if (this.contains[i]) {
                total_elements[index] = i;
                index += 1;
            }
            i += 1;
        }
        return total_elements;
=======
        // TODO
        return new int[8];
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }
}