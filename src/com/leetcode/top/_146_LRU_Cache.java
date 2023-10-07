package com.leetcode.top;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU_Cache {
    //https://leetcode.com/problems/lru-cache/
    //FOREIGN_SOLUTION
    //TOP

    class LRUCache {
        private Map<Integer, Node> map = new HashMap();
        private int capacity;
        private Node first = null;
        private Node last = null;

        public class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            var newFirst = map.get(key);
            if (newFirst == null) return -1;

            if (first.val == newFirst.val && first.key == newFirst.key) return first.val;

            if (newFirst.key == last.key) {
                var tmp = last.next;
                first = last;
                last = tmp;
                return newFirst.val;
            }
            if (newFirst.key == first.key) {
                return newFirst.val;
            }

            var tmp = newFirst.prev;
            newFirst.prev.next = newFirst.next;
            newFirst.next.prev = tmp;

            newFirst.next = last;
            newFirst.prev = first;

            last.prev = newFirst;
            first.next = newFirst;

            first = newFirst;
            return newFirst.val;
        }

        public void put(int key, int value) {
            var prevValue = map.get(key);

            if (prevValue != null) {
                get(key);
                prevValue.val = value;
                return;
            }

            if (map.size() == 0) {
                init(key, value);
                // first.next = el;
                // first.prev = el;
                // last.next = el;
                // last.prev = el;
            } else {
                if (capacity == map.size()) {
                    evict();
                    if (map.size() == 0) {
                        init(key, value);
                        return;
                    }
                }
                var el = new Node(key, value);
                el.next = last;
                el.prev = first;
                first.next = el;
                last.prev = el;
                first = el;
                map.put(key, el);
            }
        }

        private void init(int key, int value) {
            var el = new Node(key, value);
            map.put(key, el);
            el.next = el;
            el.prev = el;
            first = el;
            last = el;
        }

        private void evict() {
            var tmp = last.next;
            map.remove(last.key);
            last = tmp;
            first.next = tmp;
            tmp.prev = first;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
