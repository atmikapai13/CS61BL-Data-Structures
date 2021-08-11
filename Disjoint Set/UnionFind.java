<<<<<<< HEAD
import java.util.Arrays;

public class UnionFind {

    int[] items;
=======
public class UnionFind {

    /* TODO: Add instance variables here. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
<<<<<<< HEAD
        this.items = new int[N];
        Arrays.fill(items, -1);
=======
        // TODO: YOUR CODE HERE
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
<<<<<<< HEAD
        if (items[v] >= 0) {
            return sizeOf(items[v]);
        }
        else {
            return -1 * items[v];
        }
=======
        // TODO: YOUR CODE HERE
        return -1;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
<<<<<<< HEAD
        return items[v];
=======
        // TODO: YOUR CODE HERE
        return -1;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
<<<<<<< HEAD
        return find(v1) == find(v2);
=======
        // TODO: YOUR CODE HERE
        return false;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
<<<<<<< HEAD
        try {
            int v_rep = v;
            while (items[v_rep] >= 0) {
                v_rep = items[v_rep];
            }
            return v_rep;
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException();
        }
=======
        // TODO: YOUR CODE HERE
        return -1;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing a item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
<<<<<<< HEAD
        int v1_rep = find(v1);
        int v2_rep = find(v2);

        if (connected(v1, v2)) {
            return;
        }

        if (items[v1_rep] > items[v2_rep]) {
            items[v2_rep] += items[v1_rep];
            items[v1_rep] = v2_rep;
        }
        else if (items[v2_rep] > items[v1_rep]) {
            items[v1_rep] += items[v2_rep];
            items[v2_rep] = v1_rep;
        }
        else {
            items[v2_rep] += items[v1_rep];
            items[v1_rep] = v2_rep;
        }
=======
        // TODO: YOUR CODE HERE
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }
}
