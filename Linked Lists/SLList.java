<<<<<<< HEAD
import javax.net.ssl.SSLContext;

=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
/**
 * An SLList is a list of integers, which encapsulates the
 * naked linked list structure.
 */
public class SLList {

    /**
     * IntListNode is a nested class that represents a single node in the
     * SLList, storing an item and a reference to the next IntListNode.
     */
    private static class IntListNode {
        /*
         * The access modifiers inside a private nested class are irrelevant:
         * both the inner class and the outer class can access these instance
         * variables and methods.
         */
        public int item;
        public IntListNode next;

        public IntListNode(int item, IntListNode next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntListNode that = (IntListNode) o;
            return item == that.item;
        }

        @Override
        public String toString() {
            return item + "";
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntListNode sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntListNode(42, null);
        sentinel.next = sentinel;
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntListNode(42, null);
        sentinel.next = new IntListNode(x, null);
        sentinel.next.next = sentinel;
        size = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SLList slList = (SLList) o;
        if (size != slList.size) return false;

        IntListNode l1 = sentinel.next;
        IntListNode l2 = slList.sentinel.next;

        while (l1 != sentinel && l2 != slList.sentinel) {
            if (!l1.equals(l2)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    @Override
    public String toString() {
        IntListNode l = sentinel.next;
        String result = "";

        while (l != sentinel) {
            result += l + " ";
            l = l.next;
        }

        return result.trim();
    }

    /** Returns an SLList consisting of the given values. */
    public static SLList of(int... values) {
        SLList list = new SLList();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntListNode(x, sentinel.next);
        size += 1;
    }

    /** Return the value at the given index. */
    public int get(int index) {
        IntListNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, int x) {
<<<<<<< HEAD
        IntListNode current = sentinel;
        if (index > size - 1) {
            index = size;
        }
        while (index > 0) {
            current = current.next;
            index -= 1;
        }
        current.next = new IntListNode(x, current.next);
        size += 1;
=======
        // TODO
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /** Destructively reverses this list. */
    public void reverse() {
<<<<<<< HEAD
        if (size <= 1) {
            return;
        }
        IntListNode current1 = sentinel;
        IntListNode current2 = sentinel;
        int index1 = size;
        int index2 = 1;
        int counter = 0;
        while (counter < (size / 2)) {
            current1 = sentinel;
            current2 = sentinel;
            int i = index1;
            int j = index2;
            if (i == j) {
                counter += 1;
            } else {
                while (i > 0) {
                    current1 = current1.next;
                    i -= 1;
                }
                while (j > 0) {
                    current2 = current2.next;
                    j -= 1;
                }
                int temp = current1.item;
                current1.item = current2.item;
                current2.item = temp;
                counter += 1;
                index1 -= 1;
                index2 += 1;
            }
        }
    }

=======
        // TODO
    }
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
}
