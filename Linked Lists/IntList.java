/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
<<<<<<< HEAD
        IntList pointer = this;
        int i = 0;
        while (i < position) {
            i++;
            pointer = pointer.next;
            if (pointer == null) {
                throw new IllegalArgumentException("Out of Bounds");
            }
        }
        if (i == position) {
            return pointer.item;
        } else {
            throw new IllegalArgumentException("Out of Bounds");
        }
    }


=======
        //TODO: YOUR CODE HERE
        return -1;
    }

>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
<<<<<<< HEAD
        IntList pointer = this;
        String s = "";
        while (pointer != null) {
            s += String.valueOf(pointer.item);
            pointer = pointer.next;
        }
        s = s.replace("", " ").trim();
        return s;
=======
        //TODO: YOUR CODE HERE
        return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parenthesis. An example of this is on line 84.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntList)) {
            return false;
        }
<<<<<<< HEAD

        IntList otherLst = (IntList) obj;
        IntList pointer = this;

        while (pointer != null && otherLst != null) {
                if (pointer.item != otherLst.item) {
                    return false;
                }
                pointer = pointer.next;
                otherLst = otherLst.next;
            }
        if (pointer == null && otherLst == null) {
                return true;
        }
=======
        IntList otherLst = (IntList) obj;

        //TODO: YOUR CODE HERE

>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        return false;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
<<<<<<< HEAD
        IntList pointer = this;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new IntList(value, null);
=======
        //TODO: YOUR CODE HERE
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
<<<<<<< HEAD
        IntList pointer = this;
        int counter = pointer.item;
        while (pointer != null) {
            if (pointer.item < counter) {
                counter = pointer.item;
            }
            pointer = pointer.next;
        }
        return counter;
=======
        //TODO: YOUR CODE HERE
        return -1;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
<<<<<<< HEAD
        int result = 0;
        IntList pointer = this;
        while (pointer != null) {
            result += pointer.item*pointer.item;
            pointer = pointer.next;
        }
        return result;
=======
        //TODO: YOUR CODE HERE
        return -1;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
<<<<<<< HEAD
        if (A == null) {
            if (B == null) {
                return null;
            } else {
                return B;
            }
        }
        while (B != null) {
            A.add(B.item);
            B = B.next;
        }
        return A;
=======
        //TODO: YOUR CODE HERE
        return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
     public static IntList catenate(IntList A, IntList B) {
<<<<<<< HEAD
         if (A == null) {
             if (B == null) {
                 return null;
             } else {
                 return B;
             }
         }
             IntList result = new IntList(A.item);
             IntList list_a = A.next;
             IntList list_b = B;
             while (list_a != null) {
                 result.add(list_a.item);
                 list_a = list_a.next;
             }
             while (list_b != null) {
                 result.add(list_b.item);
                 list_b = list_b.next;
             }
             return result;
=======
        //TODO: YOUR CODE HERE
        return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
     }
}