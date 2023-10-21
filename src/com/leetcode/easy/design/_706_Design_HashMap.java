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
