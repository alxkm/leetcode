package com.leetcode.easy.design;

import java.util.Arrays;

public class _706_Design_HashMap {
    //https://leetcode.com/problems/design-hashmap/
    //706. Design HashMap

    class MyHashMap {
        private int[] l = new int[1_000_001];

        public MyHashMap() {
            Arrays.fill(l, -1);
        }

        public void put(int key, int value) {
            l[key] = value;
        }

        public int get(int key) {
            return l[key];
        }

        public void remove(int key) {
            l[key] = -1;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}


class MyHashMap {

    class Node {
        int k;
        int v;
        Node next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private final int mod = 10001;
    private final Node[] ar = new Node[mod];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        Node node = ar[key % mod];
        if (node == null) {
            ar[key % mod] = new Node(key, value);
            return;
        }

        while (node != null) {
            if (node.k == key) {
                node.v = value;
                return;
            }
            if (node.next == null) {
                node.next = new Node(key, value);
                return;
            }
            node = node.next;
        }
    }

    public int get(int key) {
        Node node = ar[key % mod];
        if (node == null) {
            return -1;
        }
        while (node != null) {
            if (node.k == key) return node.v;
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        Node node = ar[key % mod];
        if (node == null) {
            return;
        }

        if (node.k == key) {
            if (node.next == null) {
                ar[key % mod] = null;
                return;
            }
            ar[key % mod] = node.next;
            return;
        }

        if (node.next == null) return;

        Node prev = node;
        node = node.next;

        while (node != null) {
            if (node.k == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */