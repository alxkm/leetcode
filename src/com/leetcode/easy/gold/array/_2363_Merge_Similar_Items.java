package com.company.gold.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class _2363_Merge_Similar_Items {
    static public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        SortedSet<Integer> set = new TreeSet<>();
        for (var item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
            set.add(item[0]);
        }
        for (var item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
            set.add(item[0]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (var i : set) {
            List<Integer> l = new ArrayList<>(2);
            l.add(i);
            l.add(map.get(i));
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] items1 = {{1,1},{4,5},{3,8}}, items2 = {{3,1},{1,5}};

        System.out.println(mergeSimilarItems(items1, items2));
    }
}
