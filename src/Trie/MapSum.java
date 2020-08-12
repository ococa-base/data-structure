package Trie;

import java.util.TreeMap;

class MapSum {

    private class Node {
        public TreeMap<Character, Node> next;
        public int val;

        public Node(boolean isWord, int val) {
            next = new TreeMap<>();
            this.val = val;
        }
        public Node() {
            this(false, 0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        int i;
        for (i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int sum = node.val;
        for (char nextChar: node.next.keySet()) {
            sum += sum(node.next.get(nextChar));
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */