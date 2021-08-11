package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comparer;

    /** Creates a MaxArrayDeque with the given Comparator.*/
    public MaxArrayDeque(Comparator<T> c) {
        ArrayDeque<T> arr = new ArrayDeque<T>();
        this.comparer = c;
    }

    /**Returns the maximum element in the deque as governed by the previously given Comparator.
     If the MaxArrayDeque is empty, simply return null.*/
    public T max() {
        if (isEmpty()) return null;
        return max(this.comparer);
    }

    /**returns the maximum element in the deque as governed by the parameter Comparator c.
     * If the MaxArrayDeque is empty, simply return null.*/
    public T max(Comparator<T> c) {
        if (isEmpty()) return null;
        T max_elem = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (c.compare(max_elem, this.get(i)) <= 0) {
                max_elem = this.get(i);
            }
        }
        return max_elem;
    }
}