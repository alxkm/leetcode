package com.leetcode.easy.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1128_Number_of_Equivalent_Domino_Pairs {
    static public int numEquivDominoPairs1(int[][] dominoes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] a = dominoes[i];
            int b = a[1] + a[0];
            var list = map.getOrDefault(b, new ArrayList<>());
            list.add(i);
            map.put(b, list);
        }
        int counter = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                var list = entry.getValue();
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    counter += list.size() - (i + 1);
                }
            }
        }
        return counter;
    }


    static public int numEquivDominoPairs(int[][] dominoes) {
        Map<Set<Integer>, Integer> map = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] a = dominoes[i];
            var set = new HashSet<Integer>();
            set.add(a[1]);
            set.add(a[0]);
            var b = map.getOrDefault(set, 0) + 1;
            if (b >= 2) {
                counter += b - 1;
            }
            map.put(set, b);

        }
        return counter;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2}, {2,1}, {3,4}, {5,6}};
        int[][] a1 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        int[][] a2 = {{2,1},{5,4},{3,7},{6,2},{4,4},{1,8},{9,6},{5,3},{7,4},{1,9},{1,1},{6,6},{9,6},{1,3},{9,7},{4,7},{5,1},{6,5},{1,6},{6,1},{1,8},{7,2},{2,4},{1,6},{3,1},{3,9},{3,7},{9,1},{1,9},{8,9}};
        System.out.println(numEquivDominoPairs(a2));
    }
}
