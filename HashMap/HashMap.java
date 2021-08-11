import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<K, V> implements Map61BL<K, V>{

    LinkedList<Entry>[] map;
    int size;
    static int arr_length;
    static double threshold;

    /* Creates a new hash map with a default array of size 16 and a maximum load factor of 0.75. */
    public HashMap() {
        arr_length = 16;
        threshold = 0.75;
        map = new LinkedList[arr_length];
        size = 0;
    }

    /* Creates a new hash map with an array of size INITIALCAPACITY and a maximum load factor of 0.75. */
    public HashMap(int initialCapacity) {
        arr_length = initialCapacity;
        threshold = 0.75;
        map = new LinkedList[arr_length];
        size = 0;
    }

    /* Creates a new hash map with INITIALCAPACITY and LOADFACTOR. */
    public HashMap(int initialCapacity, double loadFactor) {
        arr_length = initialCapacity;
        threshold = (double) loadFactor;
        map = new LinkedList[arr_length];
        size = 0;
    }

    /* Returns the length of this HashMap's internal array. */
    public int capacity() {
        return this.arr_length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        map = new LinkedList[arr_length];
        size = 0;
    }


    @Override
    public boolean containsKey(K key) {
        Entry comparator_entry = new Entry(key, null);
        LinkedList<Entry> ll = map[comparator_entry.hashCode()];
        if (ll != null) {
            for (Entry elem : ll) {
                if (comparator_entry.keyEquals(elem)) return true;
            }
        }
        return false;
    }


    @Override
    public V get(K key) {
        if (containsKey(key)) {
            Entry comparator_entry = new Entry(key, null);
            LinkedList<Entry> ll = map[comparator_entry.hashCode()];
            for (Entry elem : ll) {
                if (comparator_entry.keyEquals(elem)) {
                    return (V) elem.value;
                }
            }
        }
        return null;
    }

   
    @Override
    public void put(K key, V value) {
        Entry new_entry = new Entry(key, value);
        if (!containsKey(key)) {
            if (resize()) resize_helper();
            int index = new_entry.hashCode();
            if (map[index] == null) {
                map[index] = new LinkedList<Entry>();
            }
            map[index].add(new_entry);
            size++;
        } else {
            int index = new_entry.hashCode();
            V val = get(key);
            Entry entry = map[index].get(map[index].indexOf(new Entry(key, val)));
            entry.value = value;
        }
    }

    public void resize_helper() {
        arr_length = arr_length * 2;
        LinkedList<Entry>[] old_hashmap = map;
        map = new LinkedList[arr_length];
        size = 0;
        for (int i = 0; i < old_hashmap.length; i++) {
            LinkedList<Entry> ll = old_hashmap[i];
            if (ll == null) continue;
            for (Entry entry : ll) {
                if (entry == null) {
                } else {
                    int index = entry.hashCode();
                    if (map[index] == null) map[index] = new LinkedList<Entry>();
                    map[index].add(entry);
                    size++;
                }
            }
        }
    }

    /* Removes a single entry, KEY, from this table and return the VALUE if
       successful or NULL otherwise. */
    public V remove(K key) {
        if (containsKey(key)) {
            Entry temp_entry = new Entry(key, null);
            LinkedList ll =  map[temp_entry.hashCode()];
            V value = get(key);
            Entry remove_entry = new Entry(key, value);
            ll.remove(remove_entry);
            map[temp_entry.hashCode()] = null;
            size--;
            return value;
        }
        return null;
    }

    public boolean remove(K key, V value) {
        if (containsKey(key) && get(key) == value) {
            remove(key);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean resize() {
        double load_factor = (double) (this.size+1)/ arr_length;
        if (load_factor > threshold) return true;
        else return false;
    }

    private class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry
                    && key.equals(((Entry) other).key)
                    && value.equals(((Entry) other).value));
        }

        @Override
        public int hashCode() {
            int val = key.hashCode();
            return Math.floorMod(val, arr_length);
        }
    }

}
