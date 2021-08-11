import java.util.LinkedList;

public class SimpleNameMap {

    LinkedList<Entry>[] map;
    int length;
    static int arr_length = 10;

    public SimpleNameMap() {
        map = new LinkedList[arr_length];
        length = 0;
    }

    /* Returns the number of items contained in this map. */
    public int size() {
        return length;
    }

    /* Returns true if the map contains the KEY. */
    public boolean containsKey(String key) {
        Entry comparator_entry = new Entry(key, null);
        LinkedList<Entry> ll = map[comparator_entry.hashCode()];
        if (ll != null) {
            for (Entry elem : ll) {
                if (comparator_entry.keyEquals(elem)) return true;
            }
        }
        return false;
    }

    /* Returns the value for the specified KEY. If KEY is not found, return
       null. */
    public String get(String key) {
        if (this.containsKey(key)) {
            Entry comparator_entry = new Entry(key, null);
            LinkedList<Entry> ll = map[comparator_entry.hashCode()];
            for (Entry elem : ll) {
                if (comparator_entry.keyEquals(elem)) {
                    return elem.value;
                }
            }
        }
        return null;
    }

    /* Puts a (KEY, VALUE) pair into this map. If the KEY already exists in the
       SimpleNameMap, replace the current corresponding value with VALUE. */
    public void put(String key, String value) {
        Entry new_entry = new Entry(key, value);
        int index = new_entry.hashCode();
        if (!this.containsKey(key)) {
            if (resize()) this.resize_helper();
            if (map[index] == null) {
                map[index] = new LinkedList<Entry>();
            }
            map[index].add(new_entry);
            length++;
        } else {
            String val = this.get(key);
            Entry entry = map[index].get(map[index].indexOf(new Entry(key, val)));
            entry.value = value;
        }
    }

    public void resize_helper() {
        arr_length *= 2;
        LinkedList<Entry>[] old_hashmap = map;
        map = new LinkedList[arr_length];
        length = 0;
        for (int i = 0; i < old_hashmap.length; i++) {
            LinkedList<Entry> ll = old_hashmap[i];
            if (ll == null) continue;
            for (Entry entry : ll) {
                if (entry == null) {
                    continue;
                } else {
                    int index = entry.hashCode();
                    if (map[index] == null) map[index] = new LinkedList<Entry>();
                    map[index].add(entry);
                    length++;
                }
            }
        }
    }

    /* Removes a single entry, KEY, from this table and return the VALUE if
       successful or NULL otherwise. */
    public String remove(String key) {
        if (this.containsKey(key)) {
            Entry temp_entry = new Entry(key, null);
            LinkedList ll =  map[temp_entry.hashCode()];
            String value = this.get(key);
            Entry remove_entry = new Entry(key, value);
            ll.remove(remove_entry);
            map[temp_entry.hashCode()] = null;
            length--;
            return value;
        }
        return null;
    }

    public boolean resize() {
        double load_factor = (this.size()+1)/ map.length;
        double threshold = 0.75;
        return load_factor > threshold;
    }

    private static class Entry {

        private String key;
        private String value;

        Entry(String key, String value) {
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