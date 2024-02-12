package com.leetcode.easy.design;

public class _705_Design_HashSet {
    //705. Design HashSet
    //https://leetcode.com/problems/design-hashset/

    class MyHashSet {
        class Node {
            int k;
            Node next;
            public Node(int k) {
                this.k = k;
            }
        }
        private final int size = 1000001;
        private final Node[] ar;

        public MyHashSet() {
            ar = new Node[size];
        }

        public void add(int key) {
            int k = key % size;
            var list = ar[k];
            if (list == null) {
                ar[k] = new Node(key);
                return;
            }
            while (list != null) {
                if (list.k == key) {
                    return;
                }
                if (list.next == null) {
                    list.next = new Node(key);
                    return;
                }
                list = list.next;
            }
        }

        public void remove(int key) {
            int k = key % size;
            var list = ar[k];
            if (list == null || (list.k != key && list.next == null)) return;
            if (list.k == key) {
                ar[k] = list.next;
                return;
            }
            var prev = list;
            list = list.next;
            while (list != null) {
                if (list.k != key) {
                    prev.next = list.next;
                    return;
                }
                prev = list;
                list = list.next;
            }
        }

        public boolean contains(int key) {
            int k = key % size;
            var list = ar[k];
            if (list == null) return false;

            while (list != null) {
                if (list.k == key) {
                    return true;
                }
                list = list.next;
            }
            return false;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
