package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1282_Group_the_People_Given_the_Group_Size_They_Belong_To {
    static public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answ = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            var list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }

        while (true) {
            Set<Integer> remove = new HashSet<>();
            for (var entry : map.entrySet()) {
                if (entry.getValue() == null || entry.getValue().isEmpty()) {
                    map.remove(entry.getKey());
                }
                var l = entry.getValue();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < entry.getKey(); i++) {
                    list.add(l.get(i));
                }
                l.removeAll(list);
                answ.add(list);
                if (l.isEmpty()) {
                    remove.add(entry.getKey());
                    map.put(entry.getKey(), null);
                }
            }

            for (var i : remove) {
                map.remove(i);
            }

            if (map.isEmpty()) break;
        }

        return answ;
    }

    public static void main(String[] args) {
        int[] a = {3,3,3,3,3,1,3};
        System.out.println(groupThePeople(a));
    }
}
