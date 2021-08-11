import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTrieSet implements TrieSet61BL {

    private static class Node {
        private boolean isKey;
        private Map<Character, Node> map;

        private Node() {
            isKey = false;
            map = new HashMap<>();
        }
    }

    public Node root;

    public MyTrieSet() {
        root = new Node();
    }

    /** Clears all items out of Trie */
    public void clear() {
        root.map.clear();
    }


    /** Returns true if the Trie contains KEY, false otherwise */
    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1) {
            return false;
        }
        Node curr = root;

        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                return false;
            }
            curr = curr.map.get(c);
        }
        if (curr.isKey) {
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) {
            return;
        }
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new Node());
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }



    /** Returns a list of all words that start with PREFIX */
    public List<String> keysWithPrefix(String prefix) {
        if (prefix == null || prefix.length() < 1) {
            throw new IllegalArgumentException("argument to keysWithPrefix() is null");
        }
        Node curr = root;
        for (int i = 0, n = prefix.length(); i < n; i++){
            char c = prefix.charAt(i);
            if (!curr.map.containsKey(c)) {
                return new ArrayList<>();
            }
            curr = curr.map.get(c);
        }
        return helper(prefix, new ArrayList<>(), curr);
    }

    //As seen on TRIESet on Princeton - https://algs4.cs.princeton.edu/52trie/TrieSET.java.html
    private List<String> helper(String str, List<String> stringList, Node node) {
        if (node.isKey == true) stringList.add(str);

        if (!node.map.isEmpty()) {
            for (Character c : node.map.keySet()) {
                helper(str + c, stringList, node.map.get(c));
            }
        }
        return stringList;
    }

    @Override
    public String longestPrefixOf(String key) {
        if (key == null) throw new IllegalArgumentException("argument to longestPrefixOf() is null");
        throw new UnsupportedOperationException();
    }
}
