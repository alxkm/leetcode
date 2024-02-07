package com.leetcode.top.top175;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _451_Sort_Characters_By_Frequency {
    //451. Sort Characters By Frequency
    //https://leetcode.com/problems/sort-characters-by-frequency/

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!map.keySet().isEmpty()) {
            char key = ' ';
            int value = Integer.MIN_VALUE;
            for (var entry: map.entrySet()) {
                if (entry.getValue() > value) {
                    key = entry.getKey();
                    value = entry.getValue();
                }
            }
            map.remove(key);
            for (int i = 0; i < value; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public String frequencySort1(String s) {
        int[][] fr = new int[75][2];
        for (char ch: s.toCharArray())  {
            int i = ch - '0';
            fr[i][0] = i;
            fr[i][1]++;
        }
        Arrays.sort(fr, (x, y) -> y[1] - x[1]);
        StringBuilder sb = new StringBuilder();
        for (int[] x: fr) {
            if (x[1] != 0) {
                for (int i = 0; i < x[1]; i++) {
                    sb.append((char)(x[0] + '0'));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new _451_Sort_Characters_By_Frequency();
        System.out.println(sol.frequencySort1("tree"));
    }
}
