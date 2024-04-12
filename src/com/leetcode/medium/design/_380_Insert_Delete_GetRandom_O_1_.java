package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class _380_Insert_Delete_GetRandom_O_1_ {
    //380. Insert Delete GetRandom O(1)
    //https://leetcode.com/problems/insert-delete-getrandom-o1/

    static class RandomizedSet {

        private class Node {
            int val;
            Node next;

            public Node(int v) {
                this.val = v;
            }

            public Node(int v, Node next) {
                this.val = v;
                this.next = next;
            }
        }

        private Node[] set = new Node[100100];
        private int h = 100001;
        private List<Integer> indexes = new ArrayList<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            int key = Math.abs(val) % h;
            if (set[key] == null) {
                set[key] = new Node(val);
                indexes.add(key);
                return true;
            }
            Node h = set[key];
            while (h != null) {
                if (h.val == val) return false;
                h = h.next;
            }

            set[key] = new Node(val, set[key]);
            indexes.add(key);
            return true;
        }

        public boolean remove(int val) {
            int key = Math.abs(val) % h;
            if (set[key] == null) {
                return false;
            }

            Node h = set[key];
            Node prev = h;
            h = h.next;

            if (h == null) {
                if (prev.val != val) return false;
                set[key] = null;
                indexes.remove(indexes.indexOf(key));
                return true;
            }

            if (prev.val == val) {
                set[key] = h;
                indexes.add(key);
                return true;
            }

            while (h != null) {
                if (h.val == val) {
                    prev.next = h.next;
                    indexes.remove(indexes.indexOf(key));
                    return true;
                }
                prev = h;
                h = h.next;
            }
            return false;
        }

        public int getRandom() {
            int index = new Random().nextInt(indexes.size());
            int item = indexes.get(index);
            Node h = set[item];

            int size = 0;

            while (h != null) {
                size++;
                h = h.next;
            }

            h = set[item];

            if (size == 1) return h.val;

            index = new Random().nextInt(size);

            for (int i = 0; i < index; i++) {
                h = h.next;
            }
            return h.val;
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */

    public static void main(String[] args) {
//        RandomizedSet rs = new RandomizedSet();
//        System.out.println(rs.insert(1));
//        System.out.println(rs.remove(2));
//        System.out.println(rs.insert(2));
//        System.out.println(rs.getRandom());
//        System.out.println(rs.remove(1));
//        System.out.println(rs.insert(2));
//        System.out.println(rs.getRandom());

        // Given set of instructions and data
        String[] instructions = {"RandomizedSet", "insert", "insert", "getRandom", "insert", "insert", "remove", "remove", "remove", "insert", "remove", "getRandom", "insert", "remove", "remove", "insert", "insert", "insert", "insert", "insert", "insert"};
        List<Integer> data = List.of(Integer.MAX_VALUE, 2, 0, Integer.MAX_VALUE, -2, -2, 3, 3, 1, -3, 3, Integer.MAX_VALUE, -3, -1, 3, 1, 1, 1, -2, 2, -3);
        List<Object> expectedResults = List.of(new Object(), true, true, 2, true, false, false, false, false, true, false, 2, false, false, false, true, false, false, false, false, false);

        // Create RandomizedSet instance
        RandomizedSet randomizedSet = null;

        // Process instructions
        for (int i = 0; i < instructions.length; i++) {
            String instruction = instructions[i];
            Integer value = data.get(i);
            Object expectedResult = expectedResults.get(i);

            switch (instruction) {
                case "RandomizedSet":
                    randomizedSet = new RandomizedSet();
                    break;
                case "insert":
                    boolean insertResult = randomizedSet.insert(value);
                    System.out.println("insert: " + insertResult + ", Expected: " + expectedResult);
                    break;
                case "remove":
                    boolean removeResult = randomizedSet.remove(value);
                    System.out.println("remove: " + removeResult + ", Expected: " + expectedResult);
                    break;
                case "getRandom":
                    int random = randomizedSet.getRandom();
                    System.out.println("getRandom: " + random + ", Expected: " + expectedResult);
                    break;
                default:
                    System.out.println("Unknown instruction: " + instruction);
            }
        }
    }
}

class RandomizedSet {
    private final Random random = new Random();
    private final Map<Integer, Integer> map = new HashMap<>();
    private int[] vals = new int[32];
    private int i = 0;

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        Integer added = map.putIfAbsent(val, i);
        if (added != null) return false;

        if (i >= vals.length) {
            vals = Arrays.copyOf(vals, vals.length * 2);
        }
        vals[i++] = val;
        return true;
    }

    public boolean remove(int val) {
        Integer removed = map.remove(val);
        if (removed == null) return false;

        if (removed < i - 1) {
            vals[removed] = vals[i - 1];
            map.put(vals[i - 1], removed);
        }
        i--;
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(i);
        return vals[index];
    }
}

