package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class _2349_Design_a_Number_Container_System {
    //2349. Design a Number Container System
    //https://leetcode.com/problems/design-a-number-container-system/description/

    class NumberContainers {

        Map<Integer, TreeSet<Integer>> indexMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            Integer prev = map.get(index);
            if (prev != null) indexMap.get(prev).remove(index);

            map.put(index, number);
            var set = indexMap.get(number);
            if (set == null) {
                set = new TreeSet<>();
            }
            set.add(index);
            indexMap.put(number, set);
        }

        public int find(int number) {
            var set = indexMap.get(number);
            if (set != null && set.size() != 0) {
                return indexMap.get(number).first();
            }
            return -1;
        }
    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int next = map.get(s.charAt(i));
            if (next == i) {
                l.add(1);
                continue;
            }
            int start = i;
            while (i <= next && i < s.length()) {
                next = Math.max(map.get(s.charAt(i)), next);
                i++;
            }
            l.add(i - start);
            i = next;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
