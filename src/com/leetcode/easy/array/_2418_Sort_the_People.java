package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2418_Sort_the_People {
    //2418. Sort the People
    //https://leetcode.com/problems/sort-the-people/description/

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        int l = 0;
        int size = map.size();
        for (int i = 0; i < size; i++) {
            String value = "";
            int key = 0;
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getKey() > key) {
                    value = entry.getValue();
                    key = entry.getKey();
                }
            }
            names[l++] = value;
            map.remove(key);
        }
        return names;
    }

    public String[] sortPeople1(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int[][] array = new int[names.length][2];
        for (int i = 0; i < names.length; i++) {
            map.put(i, names[i]);
            array[i][0] = i;
            array[i][1] = heights[i];
        }
        Arrays.sort(array, (x, y) -> y[1] - x[1]);
        String[] ar = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            ar[i] = map.get(array[i][0]);
        }
        return ar;
    }
}
